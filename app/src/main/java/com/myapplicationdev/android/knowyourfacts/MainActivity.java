package com.myapplicationdev.android.knowyourfacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> fragments;
    MyFragmentPagerAdapter adapter;
    ViewPager viewPager;
    Button btnRL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        btnRL = findViewById(R.id.btnRL);

        FragmentManager fm = getSupportFragmentManager();

        fragments = new ArrayList<Fragment>();
        fragments.add(new Frag1());
        fragments.add(new Frag2());
        fragments.add(new Frag3());
        fragments.add(new Frag4());
        fragments.add(new Frag5());

        adapter = new MyFragmentPagerAdapter(fm, fragments);

        viewPager.setAdapter(adapter);

        btnRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }//end of onCreate


    protected void onPause() {
        super.onPause();

        int lastPosition = viewPager.getCurrentItem();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("lastPosition", lastPosition);
        prefEdit.commit();
    }//end of onPause()


    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int lastPosition = prefs.getInt("lastPosition", 0);
        viewPager.setCurrentItem(lastPosition, false);
    }//end of onPause()




}//end of class