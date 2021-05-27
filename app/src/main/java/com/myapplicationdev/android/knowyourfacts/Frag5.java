package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


public class Frag5 extends Fragment {
    Button btnF5;
    int[] colours = {Color.rgb(255, 163, 175), Color.rgb(234, 253, 207), Color.rgb(255, 252, 153), Color.rgb(188, 211, 156), Color.rgb(177, 248, 242)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Frag5 = inflater.inflate(R.layout.fragment_5, container, false);
        btnF5 = Frag5.findViewById(R.id.btnF5);



        btnF5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randColour = random.nextInt(colours.length);
                Frag5.setBackgroundColor(colours[randColour]);
            }
        });

        return Frag5;
    }
}