package com.abdelalimallam.instarefrance.retrofit;

import com.abdelalimallam.instarefrance.model.UsersResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Moh Nage7 on 09/10/2016.
 */

public interface ApiInterface {

    @POST("/user/users-list")
    void getUsersList(Callback<UsersResponse> callback);

}
