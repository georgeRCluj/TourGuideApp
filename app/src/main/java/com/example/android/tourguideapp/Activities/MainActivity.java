package com.example.android.tourguideapp.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.example.android.tourguideapp.Adapters.TabsCategoryAdapter;
import com.example.android.tourguideapp.R;

public class MainActivity extends AppCompatActivity {
    public static ViewPager viewPager;
    public static TabsCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeUiComponents();
        initializeTabAndViewPager();
        changeActionBarTitleDependingOnTheCurrentTab();
    }

    private void initializeUiComponents() {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initializeTabAndViewPager() {
        adapter = new TabsCategoryAdapter(MainActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setCustomView(R.layout.tab_1_museums);
        tabLayout.getTabAt(1).setCustomView(R.layout.tab_2_churches);
        tabLayout.getTabAt(2).setCustomView(R.layout.tab_3_statues);
        tabLayout.getTabAt(3).setCustomView(R.layout.tab_4_parks);
    }

    private void changeActionBarTitleDependingOnTheCurrentTab() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        getSupportActionBar().setTitle(R.string.Fragment_1_name);
                        break;
                    case 1:
                        getSupportActionBar().setTitle(R.string.Fragment_2_name);
                        break;
                    case 2:
                        getSupportActionBar().setTitle(R.string.Fragment_3_name);
                        break;
                    case 3:
                        getSupportActionBar().setTitle(R.string.Fragment_4_name);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}