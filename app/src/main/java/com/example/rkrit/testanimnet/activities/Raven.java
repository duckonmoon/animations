package com.example.rkrit.testanimnet.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rkrit.testanimnet.R;
import com.example.rkrit.testanimnet.fragments.RavenFragment;

import java.util.LinkedList;


//AppCompatActivity дозволяє використовувати і меню і фрагменти
public class Raven extends AppCompatActivity {
    //кількість сторінок на які я хочу поділити
    public static final int NUM_PAGES = 10;

    //це якраз треба виправити
    private static LinkedList<String> ravenPages;
    // штука яка дозволяє нам свайпити вліво вправо для переходу між сторінками тексту
    private ViewPager viewPager;
    // адаптер для тої штуки
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raven);

        // знаходимо на нашій xml пейджер і дивимось чи актіті вже була запущена , щоб не накладати фрагменти один на одного
        viewPager = (ViewPager) findViewById(R.id.pager);
        if (savedInstanceState == null) {
            getRavenPages();
            // клас адаптера внизу нічого особливого, можливо рішення там, я хз
            pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

            viewPager.setAdapter(pagerAdapter);
            //коли ми свайпаєм вліво вправо або по меню клікаєм, щоб щось ствалось
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

    // ця функція при запуску актівіті додає меню , тобото ту штучку в екшн барі
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.breakit, menu);

        menu.findItem(R.id.prev).setEnabled(viewPager.getCurrentItem() > 0);

        MenuItem item = menu.add(Menu.NONE, R.id.next, Menu.NONE,
                (viewPager.getCurrentItem() == pagerAdapter.getCount() - 1)
                        ? R.string.finish
                        : R.string.next);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    // ну і що відбувається при кліці на меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.prev:
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                return true;

            case R.id.next:
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                if (item.getTitle().toString().equals(getString(R.string.finish))){
                    startActivity(new Intent(this,FlippedActivity.class));
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //дічайша функція яка ділить стрінг на 10 частин
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

    //чергова моя дика функція
    public static LinkedList<String> getRav()
    {
        ravenPages.add(ravenPages.size(),ravenPages.get(0));
        ravenPages.remove(0);
        return ravenPages;
    }

    //кнопка на телефоні назад клікається і що відбувається
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    // простий адаптер який кожній сторінці присвоює свій фрагмент
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

