package com.abdelalimallam.instarefrance.model;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Moh Nage7 on 09/10/2016.
 */

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("instagram_link")
    private String instagram_link;
    @SerializedName("followers_count")
    private String followers_count;
    @SerializedName("photo")
    private String photo;
    @SerializedName("about_account")
    private String about_account;
    @SerializedName("rate")
    private String rate;
    @SerializedName("female_to_male_rate_image")
    private String female_to_male_rate_image;
    @SerializedName("ar-en")
    private String ar_en;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public User(String id, String name, String email, String instagram_link, String followers_count, String photo, String about_account, String rate, String female_to_male_rate_image, String ar_en, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.instagram_link = instagram_link;
        this.followers_count = followers_count;
        this.photo = photo;
        this.about_account = about_account;
        this.rate = rate;
        this.female_to_male_rate_image = female_to_male_rate_image;
        this.ar_en = ar_en;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

//    public User(String name, String instagram_link, String email) {
//        this.name = name;
//        this.instagram_link = instagram_link;
//        this.email = email;
//    }

    protected User(Parcel in) {
        id = in.readString();
        name = in.readString();
        email = in.readString();
        instagram_link = in.readString();
        followers_count = in.readString();
        photo = in.readString();
        about_account = in.readString();
        rate = in.readString();
        female_to_male_rate_image = in.readString();
        ar_en = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram_link() {
        return instagram_link;
    }

    public void setInstagram_link(String instagram_link) {
        this.instagram_link = instagram_link;
    }

    public String getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAbout_account() {
        return about_account;
    }

    public void setAbout_account(String about_account) {
        this.about_account = about_account;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFemale_to_male_rate_image() {
        return female_to_male_rate_image;
    }

    public void setFemale_to_male_rate_image(String female_to_male_rate_image) {
        this.female_to_male_rate_image = female_to_male_rate_image;
    }

    public String getAr_en() {
        return ar_en;
    }

    public void setAr_en(String ar_en) {
        this.ar_en = ar_en;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
