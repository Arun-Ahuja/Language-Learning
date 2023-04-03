package com.example.sindhilearning.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.RhymesAdapter;
import com.example.sindhilearning.beans.RhymesBean;
import com.example.sindhilearning.classes.BAL;
import com.example.sindhilearning.classes.Util;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;


public class RhymesFrag extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<RhymesBean> list;
    private Button btn_play_rhyme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_rhymes, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rv_rhymes);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


            new BAL();

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Util.rhyme_selected_position=position;
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new RhymesDetailFrag()).addToBackStack(null).commit();

            }
        };


        recyclerView.setAdapter(new RhymesAdapter(listener, BAL.list));




        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



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
