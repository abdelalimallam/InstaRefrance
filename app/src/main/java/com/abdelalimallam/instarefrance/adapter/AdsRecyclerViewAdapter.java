package com.abdelalimallam.instarefrance.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdelalimallam.instarefrance.R;
import com.abdelalimallam.instarefrance.model.Ads;
import com.abdelalimallam.instarefrance.utils.TimeCalculator;

import java.util.ArrayList;

public class AdsRecyclerViewAdapter extends RecyclerView.Adapter<AdsRecyclerViewAdapter.ViewHolder> {
    Context mContext;
    private final ArrayList<Ads> mValues;

    public AdsRecyclerViewAdapter(ArrayList<Ads> items,Activity context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ads_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Ads ad = mValues.get(position);
        holder.accountName.setText(ad.getName());
        TimeCalculator calc = new TimeCalculator();
        long timeInMilli = calc.getArticleTimeInMilliSec(ad.getCreated_at(),mContext);
        holder.date.setText(calc.getTimeAgo(timeInMilli,mContext));
        holder.price.setText(ad.getPrice());
        holder.moreDetails.setText(ad.getMore_details());

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
        final TextView accountName, date, price, moreDetails;

        ViewHolder(View view) {
            super(view);
            mView = view;
            accountName = (TextView) view.findViewById(R.id.account_name);
            date = (TextView) view.findViewById(R.id.created_at);
            price = (TextView) view.findViewById(R.id.priceTV);
            moreDetails = (TextView) view.findViewById(R.id.more_details);

        }

    }
}
