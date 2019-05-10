package com.guru.abtesting.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.guru.abtesting.fragments.MyWatchList;
import com.guru.abtesting.fragments.Nifty50;
import com.guru.abtesting.fragments.Sensex30;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
//        if(AppState.user!=null) {
//            if (AppState.user.getEmail().toString().equals("raj2red@gmail.com")) {
                switch (index) {
                    case 0:
                        return new MyWatchList();
                    case 1:
                        return new Nifty50();
                    case 2:
                        return new Sensex30();

                }
//            } else {
//                switch (index) {
//                    case 0:
//                        return new Schedules();
////                    case 1:
////                        return new Team();
//                    case 1:
//                        return new Profile();
//
//                }
//            }
//        }else {
//            switch (index) {
//                case 0:
//                    return new Schedules();
////                    case 1:
////                        return new Team();
//                case 1:
//                    return new Profile();
//
//            }
//        }


        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        int intToReturn=3;

//        if(AppState.user!=null){
//            if(AppState.user.getEmail().toString().equals("raj2red@gmail.com")) {
//                intToReturn= 3;
//            }else {
//                intToReturn= 2;
//            }
//        }

        return intToReturn;
    }

}