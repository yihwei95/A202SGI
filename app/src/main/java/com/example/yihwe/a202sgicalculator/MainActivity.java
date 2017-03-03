package com.example.yihwe.a202sgicalculator;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    ViewPager Tab;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position){
                actionBar=getActionBar();
                actionBar.setSelectedNavigationItem(position);
            }
        });
        Tab.setAdapter(TabAdapter);
        actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction ft){

            }

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft){
                Tab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {

        }};

        actionBar.addTab(actionBar.newTab().setText("Basic Calculator").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Area Converter").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Length Converter").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Weight Converter").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Temperature Converter").setTabListener(tabListener));
    }
}
