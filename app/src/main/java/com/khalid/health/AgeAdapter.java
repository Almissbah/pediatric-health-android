package com.khalid.health;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khalid.health.model.AgeInfo;

import java.util.ArrayList;

public class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.MViewHolder> {

    ArrayList<AgeInfo> ageInfos;
    AdapterCallback adapterCallback;

    public AgeAdapter(ArrayList<AgeInfo> ageInfos, AdapterCallback adapterCallback) {
        this.ageInfos = ageInfos;
        this.adapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.age_list_item, parent, false);
        return new MViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
    final AgeInfo ageInfo=ageInfos.get(position);
        holder.tv_title.setText(ageInfo.getTitle().toString());
        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterCallback.onCallback(ageInfo);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ageInfos.size();
    }

   public interface AdapterCallback{
        void onCallback(AgeInfo ageInfo);
    }
    class MViewHolder extends RecyclerView.ViewHolder{
       public TextView tv_title;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
        }
    }
}
