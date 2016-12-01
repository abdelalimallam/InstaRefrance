package com.abdelalimallam.instarefrance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.abdelalimallam.instarefrance.M;
import com.abdelalimallam.instarefrance.R;
import com.abdelalimallam.instarefrance.model.CurrentUser;
import com.abdelalimallam.instarefrance.model.CurrentUserResponse;
import com.abdelalimallam.instarefrance.server.APIService;
import com.abdelalimallam.instarefrance.server.ApiInterface;
import com.abdelalimallam.instarefrance.utils.AppConst;

import net.londatiga.android.instagram.Instagram;
import net.londatiga.android.instagram.InstagramSession;
import net.londatiga.android.instagram.InstagramUser;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String CLIENT_ID = "0d03a5a67dea4e218dcb0331d986ed25";
    private static final String CLIENT_SECRET = "911b8da08638457bbbd6f87f3c1deea8";
    private static final String REDIRECT_URI = "http://www.searchplus.com";
    private InstagramSession mInstagramSession;
    private Instagram mInstagram;
    private ProgressBar mLoadingPb;
    private GridView mGridView;
    public ApiInterface retrofitAPI = APIService.createService(ApiInterface.class, AppConst.INSTAGRAM_API);


    private Instagram.InstagramAuthListener mAuthListener = new Instagram.InstagramAuthListener() {


        @Override
        public void onSuccess(final InstagramUser user) {

            retrofitAPI.getCurrentUser(user.accessToken, new Callback<CurrentUserResponse>() {
                @Override
                public void success(CurrentUserResponse currentUserResponse, Response response) {
                    CurrentUser currentUser = currentUserResponse.getCurrentUser();

                    Map<String, String> userMap = new HashMap<String, String>();
                    userMap.put("email", currentUser.getUsername());
                    userMap.put("name", currentUser.getFull_name());
                    userMap.put("instagram_link", "https://www.instagram.com/" + currentUser.getUsername() + "/");
                    userMap.put("photo", currentUser.getProfile_picture());
                    userMap.put("about_account", currentUser.getAbout_account());
                    userMap.put("followers_count", currentUser.getCounts().getFollowed_by());
                    userMap.put("ar-en", "en");

                    // Log.d("List",currentUserResponse.getCurrentUser().getCounts(0))
                    M.setUser(currentUser, LoginActivity.this);
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("failure", error.toString());
                }
            });

        }

        @Override
        public void onError(String error) {
            showToast(error);
        }

        @Override
        public void onCancel() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        mInstagram = new Instagram(this, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
        mInstagramSession = mInstagram.getSession();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1500);

                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    if (mInstagramSession.isActive()) {
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setContentView(R.layout.activity_main);
                                findViewById(R.id.btn_connect).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View arg0) {
                                        mInstagram.authorize(mAuthListener);
                                    }
                                });                            }
                        });

                    }
                }

            }
        };

        timer.start();

//
//            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
////            setContentView(R.layout.activity_user);
////
////            InstagramUser instagramUser = mInstagramSession.getUser();
////
////            mLoadingPb = (ProgressBar) findViewById(R.id.pb_loading);
////            mGridView = (GridView) findViewById(R.id.gridView);
////
////            ((TextView) findViewById(R.id.tv_name)).setText(instagramUser.fullName);
////            ((TextView) findViewById(R.id.tv_username)).setText(instagramUser.username);
////
////            findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View arg0) {
////                    mInstagramSession.reset();
////
////
////                    finish();
////                }
////            });
////
////            ImageView userIv = (ImageView) findViewById(R.id.iv_user);
////
////            Picasso.with(this).load(instagramUser.profilPicture).placeholder(R.drawable.ic_user).into(userIv);
////
//
//            //   new DownloadTask().execute();
////
////                // test button
////            Button getInfo = (Button) findViewById(R.id.btn_getinfo);
////            getInfo.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    retrofitAPI.getCurrentUser(AppConst.user.accessToken, new Callback<CurrentUserResponse>() {
////
////
////                        @Override
////                        public void success(CurrentUserResponse currentUserResponse, Response response) {
////                            Log.d("CurrentUser", currentUserResponse.toString());
////                        }
////
////                        @Override
////                        public void failure(RetrofitError error) {
////                            Log.d("failure", error.toString());
////
////                        }
////                    });
////                }
////            });
//        } else {

        //  }


    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }


//    public class DownloadTask extends AsyncTask<URL, Integer, Long> {
//        ArrayList<String> photoList;
//
//        protected void onCancelled() {
//
//        }
//
//        protected void onPreExecute() {
//
//        }
//
//        protected Long doInBackground(URL... urls) {
//            long result = 0;
//
//            try {
//                List<NameValuePair> params = new ArrayList<NameValuePair>(1);
//
//                params.add(new BasicNameValuePair("count", "10"));
//
//                InstagramRequest request = new InstagramRequest(mInstagramSession.getAccessToken());
//                String response = request.requestGet("/users/self/feed", params);
//
//                if (!response.equals("")) {
//                    JSONObject jsonObj = (JSONObject) new JSONTokener(response).nextValue();
//                    JSONArray jsonData = jsonObj.getJSONArray("data");
//
//                    int length = jsonData.length();
//
//                    if (length > 0) {
//                        photoList = new ArrayList<String>();
//
//                        for (int i = 0; i < length; i++) {
//                            JSONObject jsonPhoto = jsonData.getJSONObject(i).getJSONObject("images").getJSONObject("low_resolution");
//
//                            photoList.add(jsonPhoto.getString("url"));
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return result;
//        }
//
//        protected void onProgressUpdate(Integer... progress) {
//        }
//
//        protected void onPostExecute(Long result) {
//            mLoadingPb.setVisibility(View.GONE);
//
//            if (photoList == null) {
//                Toast.makeText(getApplicationContext(), "No Photos Available", Toast.LENGTH_LONG).show();
//            } else {
//                DisplayMetrics dm = new DisplayMetrics();
//
//                getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//                int width = (int) Math.ceil((double) dm.widthPixels / 2);
//                width = width - 50;
//                int height = width;
//
//                PhotoListAdapter adapter = new PhotoListAdapter(LoginActivity.this);
//
//                adapter.setData(photoList);
//                adapter.setLayoutParam(width, height);
//
//                mGridView.setAdapter(adapter);
//            }
//        }
//    }
}


