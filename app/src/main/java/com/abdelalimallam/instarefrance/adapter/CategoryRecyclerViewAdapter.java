package com.abdelalimallam.instarefrance.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdelalimallam.instarefrance.R;
import com.abdelalimallam.instarefrance.model.Category;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Category> categoryList;
    private Activity mContext;

    public CategoryRecyclerViewAdapter(ArrayList<Category> items, Activity context) {
        mContext = context;
        categoryList = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_user_ad_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Category currentUser = categoryList.get(position);
        holder.categoryName.setText(currentUser.getArName());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        CircleImageView categoryImage;
        TextView categoryName;

        ViewHolder(View view) {
            super(view);
            // init views
            mView = view;
            categoryImage = (CircleImageView) view.findViewById(R.id.userImage);
            categoryName = (TextView) view.findViewById(R.id.categoryName);

        }
    }


}
