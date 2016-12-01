package com.abdelalimallam.instarefrance.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.abdelalimallam.instarefrance.fragments.AdsFragment;
import com.abdelalimallam.instarefrance.fragments.CategoryFragment;
import com.abdelalimallam.instarefrance.fragments.SearchFragment;
import com.abdelalimallam.instarefrance.fragments.UsersFragment;

import java.util.ArrayList;

/**
 * Created by Moh Nage7 on 10/10/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(UsersFragment.newInstance());
        //fragments.add(CategoryFragment.newInstance());

        fragments.add(SearchFragment.newInstance());
       // fragments.add(AdsFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    /**
     * Get the current fragment
     */
    public Fragment getCurrentFragment() {
        return currentFragment;
    }

}