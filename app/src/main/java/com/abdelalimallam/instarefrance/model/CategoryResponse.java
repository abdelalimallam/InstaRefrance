package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Moh Nage7 on 10/10/2016.
 */

public class CategoryResponse {

    @SerializedName("categories")
    private ArrayList<Category> AdsList;


    public ArrayList<Category> getCategoryList() {
        return AdsList;
    }

    public void setCategoryList(ArrayList<Category> usersList) {
        this.AdsList = usersList;
    }
}
