package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


public class Frag3 extends Fragment {

    Button btnF3;
    int[] colours = {Color.rgb(255, 163, 175), Color.rgb(234, 253, 207), Color.rgb(255, 252, 153), Color.rgb(188, 211, 156), Color.rgb(177, 248, 242)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Frag3 = inflater.inflate(R.layout.fragment_3, container, false);
        btnF3 = Frag3.findViewById(R.id.btnF3);



        btnF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randColour = random.nextInt(colours.length);
                Frag3.setBackgroundColor(colours[randColour]);
            }
        });

        return Frag3;
    }
}