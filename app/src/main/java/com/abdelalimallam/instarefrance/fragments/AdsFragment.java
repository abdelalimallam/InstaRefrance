package com.abdelalimallam.instarefrance.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdelalimallam.instarefrance.R;
import com.abdelalimallam.instarefrance.adapter.AdsRecyclerViewAdapter;
import com.abdelalimallam.instarefrance.adapter.UsersRecyclerViewAdapter;
import com.abdelalimallam.instarefrance.model.Ads;
import com.abdelalimallam.instarefrance.model.AdsResponse;
import com.abdelalimallam.instarefrance.model.User;
import com.abdelalimallam.instarefrance.model.UsersResponse;
import com.abdelalimallam.instarefrance.retrofit.APIService;
import com.abdelalimallam.instarefrance.retrofit.ApiInterface;
import com.abdelalimallam.instarefrance.utils.AppConst;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AdsFragment extends Fragment {
    ApiInterface retrofitAPI;
    String TAG = "AdsFragment";
    RecyclerView recyclerView;
    View view;
    public AdsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AdsFragment newInstance() {
        return new AdsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofitAPI = APIService.createService(ApiInterface.class, AppConst.BASE_URL);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        getData();
        return view;
    }

    void getData() {

        retrofitAPI.getAdsList(new Callback<AdsResponse>() {
            @Override
            public void success(AdsResponse adsResponse, Response response) {
                ArrayList<Ads> adsList = adsResponse.getAdsList();
                Log.d(TAG, "Number of users received: " + adsList.size());
                // Set the adapter
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new AdsRecyclerViewAdapter(adsList,getActivity()));

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.getMessage());

            }
        });

    }




}
