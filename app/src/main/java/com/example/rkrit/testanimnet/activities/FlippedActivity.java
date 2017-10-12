package com.example.rkrit.testanimnet.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rkrit.testanimnet.R;
import com.example.rkrit.testanimnet.fragments.CardBackFragment;
import com.example.rkrit.testanimnet.fragments.CardFrontFragment;

public class FlippedActivity extends AppCompatActivity {
    private boolean mShowingBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fliped);
        if (savedInstanceState == null) {
            mShowingBack = false;
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new CardFrontFragment())
                    .commit();
        }
    }

    private void flipCard() {
        if (mShowingBack) {
            getFragmentManager().popBackStack();
            mShowingBack = false;
            return;
        }
        mShowingBack = true;

        getFragmentManager()
                .beginTransaction()

                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)

                .replace(R.id.container, new CardBackFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.flip_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.flip:
                flipCard();
                return true;
            case R.id.next:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
