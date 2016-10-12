package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Moh Nage7 on 12/10/2016.
 */

public class CurrentUserResponse {
    @SerializedName("data")
    private CurrentUser currentUser;

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }


}
