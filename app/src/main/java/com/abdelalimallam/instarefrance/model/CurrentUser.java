package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Moh Nage7 on 12/10/2016.
 */

public class CurrentUser {
    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String username;
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("followers_count")
    private String followers_count;
    @SerializedName("profile_picture")
    private String profile_picture;
    @SerializedName("bio")
    private String about_account;
    @SerializedName("counts")
    private Counts counts;

    public CurrentUser(String id, String username, String full_name, String followers_count, String profile_picture, String about_account, Counts counts) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
        this.followers_count = followers_count;
        this.profile_picture = profile_picture;
        this.about_account = about_account;
        this.counts = counts;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getAbout_account() {
        return about_account;
    }

    public void setAbout_account(String about_account) {
        this.about_account = about_account;
    }

}
