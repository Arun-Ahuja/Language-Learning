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
import com.example.sindhilearning.beans.ConsonentBean;
import com.example.sindhilearning.classes.Util;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;


public class ConsonentFrag extends Fragment {

    ArrayList<ConsonentBean> list;
    RecyclerView rv;
    MediaPlayer  mPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_consonent, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv_consonants);
        setUpConsonentlist();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),4);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());

        final RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Util.rhyme_selected_position=position;

                Toast.makeText(getActivity(),""+list.get(position).getConsonent(),Toast.LENGTH_SHORT).show();
                mPlayer = MediaPlayer.create(getActivity(), list.get(position).getSound());
                if (!mPlayer.isPlaying()){
                    mPlayer.start();
                }


               // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new RhymesDetailFrag()).addToBackStack(null).commit();

            }
        };
        rv.setAdapter(new AdapterConsonant(listener,list));


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

    private void setUpConsonentlist(){
        list=new ArrayList<>();



        list.add(new ConsonentBean(4,"ڀ",R.raw.bhey_bhit,Color.parseColor("#006400")));
        list.add(new ConsonentBean(3,"ٻ",R.raw.bey_bili,Color.parseColor("#0B0EED")));
        list.add(new ConsonentBean(2,"ب",R.raw.bey_badaq,Color.parseColor("#9B870c")));
        list.add(new ConsonentBean(1,"ا",R.raw.alif, Color.parseColor("#F53911")));

        list.add(new ConsonentBean(8,"ٺ",R.raw.they_thoth,Color.parseColor("#08F5DC")));
        list.add(new ConsonentBean(7,"ٽ",R.raw.tey_topi,Color.parseColor("#34495E")));
        list.add(new ConsonentBean(6,"ٿ",R.raw.thye_thelo,Color.parseColor("#DFF507")));
        list.add(new ConsonentBean(5,"ت",R.raw.te_taaro,Color.parseColor("#DD08EF")));

        list.add(new ConsonentBean(12,"ڄ",R.raw.jye_jhib,Color.parseColor("#FFA07A")));
        list.add(new ConsonentBean(11,"ج",R.raw.jem_jahaz,Color.parseColor("#FF0000")));
        list.add(new ConsonentBean(10,"پ",R.raw.pay_pagh,Color.parseColor("#00FF00")));
        list.add(new ConsonentBean(9,"ث",R.raw.say_samar,Color.parseColor("#0869F5")));

        list.add(new ConsonentBean(16,"ڇ",R.raw.chay_chatri,Color.parseColor("#000080")));
        list.add(new ConsonentBean(15,"چ",R.raw.chay_chand,Color.parseColor("#008080")));
        list.add(new ConsonentBean(14,"ڃ",R.raw.jye_janj,Color.parseColor("#00FFFF")));
        list.add(new ConsonentBean(13,"جھ",R.raw.jhay_jhirki,Color.parseColor("#808000")));

        list.add(new ConsonentBean(20,"ڌ",R.raw.dhe_dhobi,Color.parseColor("#0869F5")));
        list.add(new ConsonentBean(17,"ح",R.raw.hey_huko,Color.parseColor("#FF00FF")));
        list.add(new ConsonentBean(18,"خ",R.raw.khay_khat,Color.parseColor("#800080")));
        list.add(new ConsonentBean(19,"د",R.raw.daal_dar,Color.parseColor("#DFF507")));

        list.add(new ConsonentBean(24,"ذ",R.raw.zaal_zaro,Color.parseColor("#28B463")));
        list.add(new ConsonentBean(23,"ڍ",R.raw.dhe_dhago,Color.parseColor("#5D6D7E")));
        list.add(new ConsonentBean(22,"ڊ",R.raw.dre_drakh,Color.parseColor("#9B870c")));
        list.add(new ConsonentBean(21,"ڏ",R.raw.dey_dedar,Color.parseColor("#006400")));

        list.add(new ConsonentBean(28,"س",R.raw.seen_sij,Color.parseColor("#0B0EED")));
        list.add(new ConsonentBean(27,"ز",R.raw.z_zanjir,Color.parseColor("#08F5DC")));
        list.add(new ConsonentBean(26,"ڙ",R.raw.ray_mari,Color.parseColor("#1B4F72")));
        list.add(new ConsonentBean(25,"ر",R.raw.rey_rail,Color.parseColor("#CD6155")));

        list.add(new ConsonentBean(32,"ط",R.raw.tue_toto,Color.parseColor("#797429")));
        list.add(new ConsonentBean(31,"ض",R.raw.zuaad_zaeef,Color.parseColor("#0A0009")));
        list.add(new ConsonentBean(30,"ص",R.raw.saad_soof,Color.parseColor("#08F1F5")));
        list.add(new ConsonentBean(29,"ش",R.raw.sheen_shenh,Color.parseColor("#2108F5")));

        list.add(new ConsonentBean(36,"ف",R.raw.fey_fauji,Color.parseColor("#D3E81E")));
        list.add(new ConsonentBean(35,"غ",R.raw.gain_galeecho,Color.parseColor("#7B6254")));
        list.add(new ConsonentBean(34,"ع",R.raw.ain_ainak,Color.parseColor("#1EF635")));
        list.add(new ConsonentBean(33,"ظ",R.raw.zue_zalim,Color.parseColor("#89766D")));

        list.add(new ConsonentBean(40,"ک",R.raw.kh_khat,Color.parseColor("#000000")));
        list.add(new ConsonentBean(39,"ڪ",R.raw.k_kuto,Color.parseColor("#BC8F8F")));
        list.add(new ConsonentBean(38,"ق",R.raw.kaf_qalam,Color.parseColor("#0B0EED")));
        list.add(new ConsonentBean(37,"ڦ",R.raw.fai_feetho,Color.parseColor("#D2691E")));

        list.add(new ConsonentBean(44,"ڱ",R.raw.nye_sing,Color.parseColor("#4B0082")));
        list.add(new ConsonentBean(43,"گھ",R.raw.ghey_ghoro,Color.parseColor("#FF1493")));
        list.add(new ConsonentBean(42,"ڳ",R.raw.gh_ghao,Color.parseColor("#0B0EED")));
        list.add(new ConsonentBean(41,"گ",R.raw.gaaf_gudi,Color.parseColor("#D3E81E")));

        list.add(new ConsonentBean(48,"ڻ",R.raw.nun_war,Color.parseColor("#BDB76B")));
        list.add(new ConsonentBean(47,"ن",R.raw.nun_nath,Color.parseColor("#228B22")));
        list.add(new ConsonentBean(46,"م",R.raw.mem_machi,Color.parseColor("#7CFC00")));
        list.add(new ConsonentBean(45,"ل",R.raw.lam_lagar,Color.parseColor("#FF00FF")));

        list.add(new ConsonentBean(52,"ي",R.raw.ye_yaqtaro,Color.parseColor("#FFA07A")));
        list.add(new ConsonentBean(51,"ء",R.raw.alif_wao,Color.parseColor("#98FB98")));
        list.add(new ConsonentBean(50,"ھ",R.raw.hey_hath,Color.parseColor("#FF0000")));
        list.add(new ConsonentBean(49,"و",R.raw.wao_wadhu,Color.parseColor("#FF4500")));




    }

}
