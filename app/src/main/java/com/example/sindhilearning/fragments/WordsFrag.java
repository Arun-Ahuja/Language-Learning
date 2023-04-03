package com.example.sindhilearning.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.classes.Util;


public class WordsFrag extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_words, container, false);

        view.findViewById(R.id.imgcomputer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.words_index=1;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new WordsDetail()).addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.imgMath2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.words_index=2;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new WordsDetail()).addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.imgscience3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.words_index=3;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new WordsDetail()).addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.imgAnimal4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.words_index=4;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new WordsDetail()).addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.imgnature5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.words_index=5;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new WordsDetail()).addToBackStack(null).commit();
            }
        });

        return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
