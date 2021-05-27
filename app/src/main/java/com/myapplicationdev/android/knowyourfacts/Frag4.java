package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


public class Frag4 extends Fragment {

    Button btnF4;
    int[] colours = {Color.rgb(255, 163, 175), Color.rgb(234, 253, 207), Color.rgb(255, 252, 153), Color.rgb(188, 211, 156), Color.rgb(177, 248, 242)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Frag4 = inflater.inflate(R.layout.fragment_4, container, false);
        btnF4 = Frag4.findViewById(R.id.btnF4);



        btnF4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randColour = random.nextInt(colours.length);
                Frag4.setBackgroundColor(colours[randColour]);
            }
        });

        return Frag4;
    }
}