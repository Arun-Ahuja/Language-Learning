package com.example.sindhilearning.fragments;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.AdapterConsonant;
import com.example.sindhilearning.adapters.AdapterVowels;
import com.example.sindhilearning.beans.VowelBean;
import com.example.sindhilearning.classes.Util;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;


public class VowelFrag extends Fragment {

    private ArrayList<VowelBean> list;
    private RecyclerView rv_vowels;
    private MediaPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_vowel, container, false);
        rv_vowels=(RecyclerView)view.findViewById(R.id.rv_vowels);

        setUpList();


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),3);
        rv_vowels.setLayoutManager(mLayoutManager);
        rv_vowels.setItemAnimator(new DefaultItemAnimator());

        final RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Util.rhyme_selected_position=position;

                Toast.makeText(getActivity(),""+list.get(position).getVowel(),Toast.LENGTH_SHORT).show();
                mPlayer = MediaPlayer.create(getActivity(), list.get(position).getSound());
                if (!mPlayer.isPlaying()){
                    mPlayer.start();
                }


                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new RhymesDetailFrag()).addToBackStack(null).commit();

            }
        };
        rv_vowels.setAdapter(new AdapterVowels(listener,list));



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



    private void setUpList(){
        list=new ArrayList<>();

        list.add(new VowelBean(5,"او",R.raw.vowel6,Color.parseColor("#34495E")));
        list.add(new VowelBean(2," اَِ",R.raw.alif_zaa,Color.parseColor("#9B870c")));
        list.add(new VowelBean(1,"ايِ",R.raw.vowel4, Color.parseColor("#006400")));

        list.add(new VowelBean(7," اَو",R.raw.vowel7,Color.parseColor("#DD08EF")));
        list.add(new VowelBean(9,"اَي",R.raw.vowel8,Color.parseColor("#FF0000")));
        list.add(new VowelBean(4,"اي",R.raw.vowel3,Color.parseColor("#08F5DC")));

        list.add(new VowelBean(3," آ",R.raw.vowel2,Color.parseColor("#F53911")));
        list.add(new VowelBean(2," اِ",R.raw.vowel3,Color.parseColor("#0B0EED")));
        list.add(new VowelBean(6,"اُ",R.raw.alif_zaa,Color.parseColor("#DFF507")));
        list.add(new VowelBean(8," او",R.raw.vowel9,Color.parseColor("#FFA07A")));




    }

}
