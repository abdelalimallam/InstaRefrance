package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Moh Nage7 on 10/10/2016.
 */

public class AdsResponse {
    @SerializedName("ads")
    private ArrayList<Ads> AdsList;


    public ArrayList<Ads> getAdsList() {
        return AdsList;
    }

    public void setAdsList(ArrayList<Ads> usersList) {
        this.AdsList = usersList;
    }
}
