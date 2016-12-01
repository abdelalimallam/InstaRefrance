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
import com.abdelalimallam.instarefrance.adapter.UsersRecyclerViewAdapter;
import com.abdelalimallam.instarefrance.model.User;
import com.abdelalimallam.instarefrance.model.UsersResponse;
import com.abdelalimallam.instarefrance.server.APIService;
import com.abdelalimallam.instarefrance.server.ApiInterface;
import com.abdelalimallam.instarefrance.utils.AppConst;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class UsersFragment extends Fragment {
    String TAG = "UsersFragment";
    ApiInterface retrofitAPI;
    RecyclerView recyclerView;
    public UsersFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static UsersFragment newInstance() {
        return new UsersFragment();

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofitAPI = APIService.createService(ApiInterface.class, AppConst.BASE_URL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        getData();
        return view;
    }


    void getData() {

        retrofitAPI.getUsersList(new Callback<UsersResponse>() {
            @Override
            public void success(UsersResponse usersResponse, Response response) {
                ArrayList<User> usersList = usersResponse.getUsersList();
                Log.d(TAG, "Number of users received: " + usersList.size());
                // Set the adapter
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new UsersRecyclerViewAdapter(usersList,getActivity()));

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.getMessage());

            }
        });

    }

}
