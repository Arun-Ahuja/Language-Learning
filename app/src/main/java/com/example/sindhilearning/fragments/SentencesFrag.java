package com.example.sindhilearning.fragments;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.SentencesAdapter;
import com.example.sindhilearning.beans.SentenceBean;

import java.util.ArrayList;


public class SentencesFrag extends Fragment {
    private ListView lv_sentences;
    private ArrayList<SentenceBean> sentenceBeanArrayList;
    MediaPlayer mPlayer;
    private Button btn_sentence_quiz;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sentences, container, false);
        lv_sentences=(ListView)view.findViewById(R.id.lv_sentences);
        btn_sentence_quiz=(Button)view.findViewById(R.id.btn_sentence_quiz);
        setUpSentenceList();


        lv_sentences.setAdapter(new SentencesAdapter(getActivity(),sentenceBeanArrayList));
        lv_sentences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mPlayer = MediaPlayer.create(getActivity(), sentenceBeanArrayList.get(position).getSound());
                mPlayer.start();

            }
        });

        btn_sentence_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.layout, new SentenceGameFrag());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
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

        //mPlayer.stop();

    }

    private void setUpSentenceList(){
        sentenceBeanArrayList=new ArrayList<>();
        sentenceBeanArrayList.add(new SentenceBean(1,"انب کاء","Ambu Khau","Eat Mango",R.raw.sentence_1, Color.parseColor("#F53911")));
        sentenceBeanArrayList.add(new SentenceBean(2,"هتي اچ ","Hite Achu","Come here",R.raw.sentence_2,Color.parseColor("#9B870c")));
        sentenceBeanArrayList.add(new SentenceBean(3,"بس اچي ٿي ","Bas ache thi","Bus is coming",R.raw.sentence_3,Color.parseColor("#0B0EED")));
        sentenceBeanArrayList.add(new SentenceBean(4,"ٻلي ڪاري آهي ","Bilee Kaarii Ahe","Cat is black",R.raw.sentence_4,Color.parseColor("#006400")));
        sentenceBeanArrayList.add(new SentenceBean(5,"کٽ تي ويھ ","Weh Khat te","Sit on cot",R.raw.sentence_5,Color.parseColor("#DD08EF")));
        sentenceBeanArrayList.add(new SentenceBean(5,"در بند ڪر ","Dar band kar","Close the door",R.raw.sentence_6,Color.parseColor("#DFF507")));
        sentenceBeanArrayList.add(new SentenceBean(6,"فقير پني ٿو ","Faqeer pine tho","Beggar is begging",R.raw.sentence_7,Color.parseColor("#34495E")));
        sentenceBeanArrayList.add(new SentenceBean(7,"غاليچو سھڻو آھي ","Galeecho suhno ahe","Carpet is beautifull here",R.raw.sentence_8,Color.parseColor("#08F5DC")));
        sentenceBeanArrayList.add(new SentenceBean(8,"ڄڀ سڙي ٿي ","Hity Ach","Tongue is burning",R.raw.sentence_9,Color.parseColor("#0869F5")));



    }

}
