package com.abdelalimallam.instarefrance.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.abdelalimallam.instarefrance.R;
import com.abdelalimallam.instarefrance.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecyclerViewAdapter extends RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<User> mValues;
    private Activity mContext;

    public UsersRecyclerViewAdapter(ArrayList<User> items, Activity context) {
        mContext = context;
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_users_recycle_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User currentUser = mValues.get(position);
        holder.userName.setText(currentUser.getName());
        holder.followersNumber.setText(currentUser.getFollowers_count());
        if (currentUser.getPhoto().isEmpty()) {
            holder.userImage.setImageResource(R.drawable.ic_user);
        } else {
            Picasso.with(mContext).load(currentUser.getPhoto()).into(holder.userImage);

        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        CircleImageView userImage;
        TextView userName;
        TextView followersNumber;
        RatingBar ratingBar;

        ViewHolder(View view) {
            super(view);
            // init views
            mView = view;
            userImage = (CircleImageView) view.findViewById(R.id.userImage);
            userName = (TextView) view.findViewById(R.id.userName);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            followersNumber = (TextView) view.findViewById(R.id.numberOfFollowers);
//
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);


        }
    }


}
