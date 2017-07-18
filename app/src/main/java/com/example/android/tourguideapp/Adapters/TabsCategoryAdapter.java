package com.example.android.tourguideapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguideapp.Fragments.MuseumsFragment;
import com.example.android.tourguideapp.Fragments.ChurchesFragment;
import com.example.android.tourguideapp.Fragments.StatuesFragment;
import com.example.android.tourguideapp.Fragments.ParksFragment;

public class TabsCategoryAdapter extends FragmentPagerAdapter {
    private final int MUSEUMS_FRAGMENT = 0;
    private final int CHURCHES_FRAGMENT = 1;
    private final int STATUES_FRAGMENT = 2;
    private final int PARKS_FRAGMENT = 3;
    private final int ALL_FRAGMENTS = 4;

    private Context mContext;

    public TabsCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MUSEUMS_FRAGMENT:
                return new MuseumsFragment();
            case CHURCHES_FRAGMENT:
                return new ChurchesFragment();
            case STATUES_FRAGMENT:
                return new StatuesFragment();
            case PARKS_FRAGMENT:
                return new ParksFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return ALL_FRAGMENTS;
    }
}
