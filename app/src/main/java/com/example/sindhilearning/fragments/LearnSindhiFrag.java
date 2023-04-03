package com.example.sindhilearning.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.MyPagerAdapter;


public class LearnSindhiFrag extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_learn_sindhi, container, false);

//        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
//        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
//        viewPager.setAdapter(myPagerAdapter);
//        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);

        view.findViewById(R.id.imgconsonents3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new ConsonentFrag()).addToBackStack(null).commit();
            }
        });

        view.findViewById(R.id.imgvowel2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new VowelFrag()).addToBackStack(null).commit();
            }
        });

        view.findViewById(R.id.imgalphabet1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new AlphabetFrag()).addToBackStack(null).commit();
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



}
