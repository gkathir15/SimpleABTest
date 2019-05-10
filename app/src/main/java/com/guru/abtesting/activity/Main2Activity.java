package com.guru.abtesting.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.guru.abtesting.AppState;
import com.guru.abtesting.BuildConfig;
import com.guru.abtesting.R;
import com.guru.abtesting.adapters.TabsPagerAdapter;

public class Main2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private BottomNavigationView bottom_navigation;
    private TabLayout tabLayout;
    private TextView title;
    LinearLayout title_heading;
    FloatingActionMenu fab;

    private String colorPrimary, tab1_name, tab2_name, tab3_name, recycler_layout, fab_visibility;


    int tobCount;
    static int previousMenuSelected = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title_heading = (LinearLayout) findViewById(R.id.title_heading);
        viewPager = (ViewPager) findViewById(R.id.pager);
        bottom_navigation = (BottomNavigationView) findViewById(R.id.navigation);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        fab = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        tobCount = mAdapter.getCount();
        title = (TextView) findViewById(R.id.title);

        colorPrimary = AppState.firebaseRemoteConfig.getString("color_primary");
        tab1_name = AppState.firebaseRemoteConfig.getString("tab1_name");
        tab2_name = AppState.firebaseRemoteConfig.getString("tab2_name");
        tab3_name = AppState.firebaseRemoteConfig.getString("tab3_name");
        recycler_layout = AppState.firebaseRemoteConfig.getString("recycler_layout");
        fab_visibility = AppState.firebaseRemoteConfig.getString("fab_visibility");

        fab.setMenuButtonColorNormal(Color.parseColor(colorPrimary));

        if (fab_visibility.equals("false")) {
            fab.setVisibility(View.GONE);
        } else {
            fab.setVisibility(View.VISIBLE);
        }

        title_heading.setBackgroundColor(Color.parseColor(colorPrimary));
        tabLayout.setBackgroundColor(Color.parseColor(colorPrimary));

        tabLayout.addTab(tabLayout.newTab().setText(tab1_name));
        tabLayout.addTab(tabLayout.newTab().setText(tab2_name));
        tabLayout.addTab(tabLayout.newTab().setText(tab3_name));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener((new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    previousMenuSelected = 0;
                    title.setText(tab1_name);
                    bottom_navigation.setSelectedItemId(R.id.navigation_mywatchlist);
                }
                if (position == 1) {
                    previousMenuSelected = 1;
                    title.setText(tab2_name);
                    bottom_navigation.setSelectedItemId(R.id.navigation_nifty50);
                }
                if (position == 2) {
                    previousMenuSelected = 2;
                    title.setText(tab3_name);
                    bottom_navigation.setSelectedItemId(R.id.navigation_sensex30);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        }));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });


        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_mywatchlist:
                        viewPager.setCurrentItem(0, true);
                        return true;
                    case R.id.navigation_nifty50:
                        viewPager.setCurrentItem(1, true);
                        return true;
                    case R.id.navigation_sensex30:
                        viewPager.setCurrentItem(2, true);
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
