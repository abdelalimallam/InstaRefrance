package com.abdelalimallam.instarefrance.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abdelalimallam.instarefrance.R;

public class AdsFragment extends Fragment {

    public AdsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AdsFragment newInstance() {
        Log.d("AdsFragment", "newInstance");
        return new AdsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Toast.makeText(getActivity(), "AdsFragment", Toast.LENGTH_LONG).show();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            //  recyclerView.setAdapter(new UsersRecyclerViewAdapter(, ));
        }
        return view;
    }


}
