package com.abdelalimallam.instarefrance.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Adelalim on 10/12/2016.
 */

public class Category {

    @SerializedName("id")
    private String id;
    @SerializedName("ar_name")
    private String arName;
    @SerializedName("en_name")
    private String enName;
    @SerializedName("photo")
    private String photo;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
