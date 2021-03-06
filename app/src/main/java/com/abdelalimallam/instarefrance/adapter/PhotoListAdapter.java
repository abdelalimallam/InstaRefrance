package com.abdelalimallam.instarefrance.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.abdelalimallam.instarefrance.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoListAdapter extends BaseAdapter {
 	private Context mContext;
	

	private ArrayList<String> mPhotoList;
	
	private int mWidth;
	private int mHeight;
	
	public PhotoListAdapter(Context context) {
		mContext = context;
		
 	}
	
	public void setData(ArrayList<String> data) {
		mPhotoList = data;
	}
	
	public void setLayoutParam(int width, int height) {
		mWidth 	= width;
		mHeight = height;
	}
	
	@Override
	public int getCount() {
		return (mPhotoList == null) ? 0 : mPhotoList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageIv;
		
		if (convertView == null) {
			imageIv = new ImageView(mContext);
			
			imageIv.setLayoutParams(new GridView.LayoutParams(mWidth, mHeight));
            imageIv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageIv.setPadding(0, 0, 0, 0); 
		} else {
			imageIv = (ImageView) convertView;
		}
		
 		Picasso.with(mContext).load(mPhotoList.get(position)).placeholder(R.drawable.ic_user).into(imageIv);

		return imageIv;
	}
}