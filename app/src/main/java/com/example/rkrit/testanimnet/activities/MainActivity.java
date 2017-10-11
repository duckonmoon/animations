package com.example.rkrit.testanimnet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rkrit.testanimnet.R;
import com.example.rkrit.testanimnet.fragments.TransactionFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null)
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            TransactionFragment fragment = new TransactionFragment();
            transaction.replace(R.id.frame_layout,fragment);
            transaction.commit();
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
                startActivity(new Intent(this,Flip_Activity.class));
                return true;
        }
        return false;
    }


}
