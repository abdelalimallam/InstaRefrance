package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Moh Nage7 on 10/10/2016.
 */

public class UsersResponse {
    @SerializedName("users")
    private ArrayList<User> usersList;


    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }
}
