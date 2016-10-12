package com.abdelalimallam.instarefrance.retrofit;

import com.abdelalimallam.instarefrance.model.AdsResponse;
import com.abdelalimallam.instarefrance.model.CurrentUserResponse;
import com.abdelalimallam.instarefrance.model.UsersResponse;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Moh Nage7 on 09/10/2016.
 */

public interface ApiInterface {

    @POST("/user/users-list")
    void getUsersList(Callback<UsersResponse> callback);

    @POST("/ads/ads-list")
    void getAdsList(Callback<AdsResponse> callback);

//    @FormUrlEncoded
//    @POST("/user/register")
//    void addUser(@Field("name") String name,
//                 @Field("email") String email, @Field("instagram_link") String instaLink,
//                 @Field("photo") String photo, @Field("about_account") String aboutAccount
//            , @Field("followers_count") String followersCount
//            , @Field("ar-en") String ar_en, Callback<Response> serverResponseCallback);

    @FormUrlEncoded
    @GET("/users/self")
    void getCurrentUser(@Field("access_token") String accessToken, Callback<CurrentUserResponse>callback);
}
