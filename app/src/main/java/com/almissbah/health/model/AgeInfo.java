package com.almissbah.health.model;


public class AgeInfo {
    int id,days,days_until_next;
    String title,diet,length,weight;
    boolean gotToNext=false;

    public int getDays_until_next() {
        return days_until_next;
    }

    public void setDays_until_next(int days_until_next) {
        this.days_until_next = days_until_next;
    }

    public boolean isGotToNext() {
        return gotToNext;
    }

    public void setGotToNext(boolean gotToNext) {
        this.gotToNext = gotToNext;
    }

    public String getDiet() {
        return diet;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
