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
import com.abdelalimallam.instarefrance.adapter.CategoryRecyclerViewAdapter;
import com.abdelalimallam.instarefrance.adapter.UsersRecyclerViewAdapter;
import com.abdelalimallam.instarefrance.model.Category;
import com.abdelalimallam.instarefrance.model.CategoryResponse;
import com.abdelalimallam.instarefrance.model.User;
import com.abdelalimallam.instarefrance.model.UsersResponse;
import com.abdelalimallam.instarefrance.server.APIService;
import com.abdelalimallam.instarefrance.server.ApiInterface;
import com.abdelalimallam.instarefrance.utils.AppConst;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CategoryFragment extends Fragment {
    String TAG = "CategoryFragment";
    ApiInterface retrofitAPI;
    RecyclerView recyclerView;

    public CategoryFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CategoryFragment newInstance() {
        return new CategoryFragment();

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

        retrofitAPI.getCategoryList(new Callback<CategoryResponse>() {
            @Override
            public void success(CategoryResponse categoryResponse, Response response) {
                ArrayList<Category> catList = categoryResponse.getCategoryList();
                Log.d(TAG, "Number of users received: " + catList.size());
                // Set the adapter
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new CategoryRecyclerViewAdapter(catList,getActivity()));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

}
