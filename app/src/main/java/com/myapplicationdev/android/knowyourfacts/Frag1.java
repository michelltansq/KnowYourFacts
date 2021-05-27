package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;


public class Frag1 extends Fragment {

    ImageView iv;
    Button btnF1;

    int[] colours = {Color.rgb(255, 163, 175), Color.rgb(234, 253, 207), Color.rgb(255, 252, 153), Color.rgb(188, 211, 156), Color.rgb(177, 248, 242)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Frag1 =  inflater.inflate(R.layout.fragment_1, container, false);


        iv = Frag1.findViewById(R.id.iv);
        btnF1 = Frag1.findViewById(R.id.btnF1);

        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Arctic-Foxs-Colorful-Fur.png";
        Picasso.with(getActivity()).load(imageUrl).into(iv);

        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randColour = random.nextInt(colours.length);
                Frag1.setBackgroundColor(colours[randColour]);
            }
        });



        return Frag1;
    }
}