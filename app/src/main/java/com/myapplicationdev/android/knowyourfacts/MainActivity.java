package com.myapplicationdev.android.knowyourfacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.crazyhitty.chdev.ks.rssmanager.RssReader;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




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