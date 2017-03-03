package com.example.yihwe.a202sgicalculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by yihwe on 01-Mar-17.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter{

    public TabPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i){
        switch (i){
            case 0:
                return new MainCalculator();
            case 1:
                return new MainArea();
            case 2:
                return new MainLength();
            case 3:
                return new MainWeight();
            case 4:
                return new MainTemperature();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 5;
    }
}
