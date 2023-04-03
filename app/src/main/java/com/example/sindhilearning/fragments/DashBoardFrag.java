package com.example.sindhilearning.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.sindhilearning.R;


public class DashBoardFrag extends Fragment {


    RelativeLayout rl_poems, rl_basic, rl_words, rl_sentences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_dash_board, container, false);

        rl_poems=(RelativeLayout)view.findViewById(R.id.rl_poems);
        rl_basic=(RelativeLayout)view.findViewById(R.id.rl_basic);
        rl_words=(RelativeLayout)view.findViewById(R.id.rl_words);
        rl_sentences=(RelativeLayout)view.findViewById(R.id.rl_sentences);

        rl_poems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAnOtherFrag(new RhymesFrag());
            }
        });

        rl_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAnOtherFrag(new LearnSindhiFrag());

            }
        });

        rl_sentences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAnOtherFrag(new SentencesFrag());
            }
        });

        rl_words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAnOtherFrag(new WordsFrag());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    public void moveToAnOtherFrag(Fragment fragment){

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
