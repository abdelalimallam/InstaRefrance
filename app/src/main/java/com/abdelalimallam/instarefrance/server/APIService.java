package com.abdelalimallam.instarefrance.server;


import com.abdelalimallam.instarefrance.utils.AppConst;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Created by Adelalim on 12/18/2015.
 */
public class APIService {


    public APIService() {

    }


    public static <S> S createService(Class<S> serviceClass, String url) {


        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(url);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(AppConst.TIMEOUT, TimeUnit.MINUTES);
        okHttpClient.setConnectTimeout(AppConst.TIMEOUT, TimeUnit.MINUTES);
        okHttpClient.setRetryOnConnectionFailure(true);
        RestAdapter adapter = builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("RETROFIT")).setClient(new OkClient(okHttpClient))
                .build();


        return adapter.create(serviceClass);
    }

}
