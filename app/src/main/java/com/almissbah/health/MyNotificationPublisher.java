package com.almissbah.health;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.almissbah.health.model.AgeInfo;
import com.almissbah.health.model.User;
import com.almissbah.health.ui.MainActivity;
import com.khalid.health.R;

import java.util.ArrayList;

public class MyNotificationPublisher extends BroadcastReceiver {

    public static String TAG=MyNotificationPublisher.class.getSimpleName();
    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d(TAG,"alarm in onReceive ");
        int notificationId=1;
        ArrayList<AgeInfo> ages = new PrefManager(context).getAppData().getAgeInfos();
        User user = new PrefManager(context).getUser();

        for(AgeInfo ageInfo:ages){
            if((ageInfo.getId()-1)==user.getCurrentAgeInfo().getId()){
                user.setCurrentAgeInfo(ageInfo);
                new PrefManager(context).saveUser(user);
                break;
            } }
        long delay=user.getCurrentAgeInfo().getDays_until_next();
        if(delay!=0) scheduleNotification(context,delay);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText("Your son "+user.getBaby_name()+" is "+user.getCurrentAgeInfo().getTitle()+" see his vaccinations")
                .setAutoCancel(true).setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(((BitmapDrawable) context.getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        Intent activity_intent = new Intent(context, MainActivity.class);
        PendingIntent activity = PendingIntent.getActivity(context, notificationId, activity_intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(activity);

        Notification notification = builder.build();
        notificationManager.notify(notificationId, notification);


       // long delay=user.getCurrentAgeInfo().getDays_until_next()*24*60*60*1000;

    }


    public static void scheduleNotification(Context context, long delay) {
        //delay is after how much time(in millis) from current time you want to schedule the notification
      //  delay=delay*24*60*60*1000;
        Intent notificationIntent = new Intent(context, MyNotificationPublisher.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 1, notificationIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (delay * 1000), pendingIntent);
        Log.d(TAG,"alarm in "+delay+" s");
    }
}