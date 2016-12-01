package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Moh Nage7 on 15/10/2016.
 */

public class Counts {
    @SerializedName("follows")
    private String follows;
    @SerializedName("followed_by")
    private String followed_by;

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public String getFollowed_by() {
        return followed_by;
    }

    public void setFollowed_by(String followed_by) {
        this.followed_by = followed_by;
    }
}
