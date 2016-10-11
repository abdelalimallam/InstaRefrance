package com.abdelalimallam.instarefrance.retrofit;


 import com.abdelalimallam.instarefrance.AppConst;
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


    public static <S> S createService(Class<S> serviceClass) {


        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(AppConst.BASE_URL);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(AppConst.TIMEOUT, TimeUnit.MINUTES);
        okHttpClient.setConnectTimeout(AppConst.TIMEOUT, TimeUnit.MINUTES);
        okHttpClient.setRetryOnConnectionFailure(true);

//        builder.setRequestInterceptor(new RequestInterceptor() {
//            @Override
//            public void intercept(RequestFacade request) {
//                Global objGlobal = Global.getInstance(mActivity);
//                if (objGlobal.getFromSharedPrefernec(Constants.SH_SESSID) != null && !objGlobal.getFromSharedPrefernec(Constants.SH_SESSID).equalsIgnoreCase("")) {
//                    String Cookie = objGlobal.getFromSharedPrefernec(Constants.SH_SESSNAME) + "=" + objGlobal.getFromSharedPrefernec(Constants.SH_SESSID);
//                    request.addHeader("Cookie", Cookie);
//                    request.addHeader("Content-Type", "application/json");
//
//
//                }
//            }
//        });
//        RestAdapter adapter = builder.build();
        RestAdapter adapter = builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("RETROFIT")).setClient(new OkClient(okHttpClient))
                .build();


        return adapter.create(serviceClass);
    }

}
