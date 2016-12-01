package com.abdelalimallam.instarefrance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.abdelalimallam.instarefrance.M;
import com.abdelalimallam.instarefrance.R;
import com.abdelalimallam.instarefrance.model.CurrentUser;

/**
 * Created by Moh Nage7 on 27/10/2016.
 */

public class ProfileActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile_layout);
        CurrentUser currentUser = M.getUser(this);

        initViews();

    }

    private void initViews() {

    }
}
