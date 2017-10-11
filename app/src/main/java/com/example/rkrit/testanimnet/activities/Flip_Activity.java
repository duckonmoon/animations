package com.example.rkrit.testanimnet.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.rkrit.testanimnet.R;

public class Flip_Activity extends AppCompatActivity {

    private View flip;
    private View flipped;
    private int mShortAnimationDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_);
        flip = findViewById(R.id.editText);
        flipped = findViewById(R.id.imageView);
        flipped.setVisibility(View.GONE);
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.flip_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.flip:
                crossfade();
                return true;
            case R.id.next:
                startActivity(new Intent(this,Raven.class));
                return true;
        }
        return false;
    }


    private void crossfade() {
        if (flipped.getVisibility() == View.GONE) {
            flipped.setAlpha(0f);
            flipped.setVisibility(View.VISIBLE);

            flipped.animate()
                    .alpha(1f)
                    .setDuration(mShortAnimationDuration)
                    .setListener(null);

            flip.animate()
                    .alpha(0f)
                    .setDuration(mShortAnimationDuration)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            flip.setVisibility(View.GONE);
                        }
                    });
        }
        else
        {
            flip.setAlpha(0f);
            flip.setVisibility(View.VISIBLE);

            flip.animate()
                    .alpha(1f)
                    .setDuration(mShortAnimationDuration)
                    .setListener(null);

            flipped.animate()
                    .alpha(0f)
                    .setDuration(mShortAnimationDuration)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            flipped.setVisibility(View.GONE);
                        }
                    });
        }
    }
}
