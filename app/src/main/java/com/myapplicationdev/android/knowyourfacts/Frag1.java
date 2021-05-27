package com.myapplicationdev.android.knowyourfacts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Frag1 extends Fragment {

    ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Frag1 =  inflater.inflate(R.layout.fragment_1, container, false);
        iv = Frag1.findViewById(R.id.iv);
        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Arctic-Foxs-Colorful-Fur.png";
        Picasso.with(getActivity()).load(imageUrl).into(iv);
        return Frag1;
    }
}