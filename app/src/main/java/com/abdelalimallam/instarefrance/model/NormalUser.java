package com.abdelalimallam.instarefrance.model;

/**
 * Created by Moh Nage7 on 16/10/2016.
 */

public class NormalUser {
    String userName,email,password;

    public NormalUser(String password, String userName, String email) {
        this.password = password;
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
