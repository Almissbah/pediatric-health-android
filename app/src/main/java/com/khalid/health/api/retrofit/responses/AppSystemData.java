package com.khalid.health.api.retrofit.responses;

import com.google.gson.Gson;
import com.khalid.health.model.AgeInfo;
import com.khalid.health.model.Vaccination;

import java.util.ArrayList;

public class AppSystemData {
    ArrayList<AgeInfo> ageInfos;
    ArrayList<Vaccination> vaccinations;

    public ArrayList<AgeInfo> getAgeInfos() {
        return ageInfos;
    }

    public void setAgeInfos(ArrayList<AgeInfo> ageInfos) {
        this.ageInfos = ageInfos;
    }

    public ArrayList<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(ArrayList<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
