package com.example.tysonlove.newgear;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class TabbedActivity extends AppCompatActivity {


private static final String TAG ="TabbedActivity";
private SectionPageAdapter mSectionsSectionPageAdapter;
private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);


    }
    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabbedFragment(),"Tab1");
        adapter.addFragment(new TabbedFragment(),"Tab2");
        adapter.addFragment(new TabbedFragment(),"Tab2");

        viewPager.setAdapter(adapter);


    }
}
