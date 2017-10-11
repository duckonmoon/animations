package com.example.rkrit.testanimnet.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rkrit.testanimnet.R;
import com.example.rkrit.testanimnet.fragments.RavenFragment;

import java.util.LinkedList;

public class Raven extends FragmentActivity {
    public static final int NUM_PAGES = 10;

    private static LinkedList<String> ravenPages;
    private ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raven);

        viewPager = findViewById(R.id.pager);
        if (savedInstanceState == null) {
            getRavenPages();
            pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pagerAdapter);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    invalidateOptionsMenu();
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first_menu_item:
                startActivity(new Intent(this,FlipedActivity.class));
                return true;
        }
        return false;
    }

    private void getRavenPages()
    {
        String raven = getString(R.string.raven);
        ravenPages = new LinkedList<String>();
        for (int i = 0;i < 10;i++)
        {
            ravenPages.add(raven.substring(raven.length()/10*i,raven.length()/10*(i+1)));
        }
        ravenPages.add(0,ravenPages.remove(ravenPages.size()-1));
        Log.w("w","w");
    }

    public static LinkedList<String> getRav()
    {
        ravenPages.add(ravenPages.size(),ravenPages.get(0));
        ravenPages.remove(0);
        return ravenPages;
    }


    public int getCurrent()
    {
        int i = viewPager.getCurrentItem();
        return i;
    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new RavenFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}

