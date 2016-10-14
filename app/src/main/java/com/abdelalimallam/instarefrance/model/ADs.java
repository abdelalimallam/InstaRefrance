package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Adelalim on 10/12/2016.
 */

public class Ads {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("account_details")
    private String account_details;
    @SerializedName("more_details")
    private String more_details;
    @SerializedName("ar-en")
    private String ar_en;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public Ads(String id, String name, String price, String account_details, String more_details, String ar_en, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.account_details = account_details;
        this.more_details = more_details;
        this.ar_en = ar_en;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccount_details() {
        return account_details;
    }

    public void setAccount_details(String account_details) {
        this.account_details = account_details;
    }

    public String getMore_details() {
        return more_details;
    }

    public void setMore_details(String more_details) {
        this.more_details = more_details;
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
