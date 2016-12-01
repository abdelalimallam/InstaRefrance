package com.abdelalimallam.instarefrance.server;

import com.abdelalimallam.instarefrance.model.AdsResponse;
import com.abdelalimallam.instarefrance.model.CategoryResponse;
import com.abdelalimallam.instarefrance.model.CurrentUserResponse;
import com.abdelalimallam.instarefrance.model.RegisterationResponse;
import com.abdelalimallam.instarefrance.model.UsersResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Moh Nage7 on 09/10/2016.
 */

public interface ApiInterface {

    @POST("/user/users-list")
    void getUsersList(Callback<UsersResponse> callback);

    @POST("/categories/users")
    void getUsersFromCategory(Callback<UsersResponse> callback);

    @POST("/categories")
    void getCategoryList(Callback<CategoryResponse> callback);

    @POST("/ads/ads-list")
    void getAdsList(Callback<AdsResponse> callback);

    @POST("/user/register")
    void registerUser(@FieldMap Map<String, String> userMap, Callback<RegisterationResponse> serverResponseCallback);

    @GET("/users/self/")
    void getCurrentUser(@Query("access_token") String accessToken, Callback<CurrentUserResponse> callback);


    @FormUrlEncoded
    @POST("/user/register")
    void addUser(@Field("name") String name,
                 @Field("email") String email, @Field("instagram_link") String instaLink,
                 @Field("photo") String photo, @Field("about_account") String aboutAccount
            , @Field("followers_count") String followersCount
            , @Field("ar-en") String ar_en, Callback<RegisterationResponse> serverResponseCallback);
}
