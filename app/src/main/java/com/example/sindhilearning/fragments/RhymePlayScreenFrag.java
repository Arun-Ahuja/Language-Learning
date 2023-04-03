package com.example.sindhilearning.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.classes.BAL;
import com.example.sindhilearning.classes.Util;
import com.example.sindhilearning.classes.Utilities;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class RhymePlayScreenFrag extends Fragment {



    private boolean isPlaying=false;
     MediaPlayer mp;
     private Button btn_play;
    MediaPlayer mPlayer;
    private SeekBar seekbar;
    private Handler myHandler = new Handler();;
    Utilities utils;
    private TextView tv_rhyme_play_screen, tv_sindh, tv_eng;
    ScrollView scrollView2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_rhyme_play_screen, container, false);
        btn_play=(Button)view.findViewById(R.id.btn_play);
        seekbar=(SeekBar)view.findViewById(R.id.seekbar);
        tv_rhyme_play_screen=(TextView)view.findViewById(R.id.tv_rhyme_play_screen);
        scrollView2=(ScrollView)view.findViewById(R.id.scrollView2);
        tv_eng=(TextView)view.findViewById(R.id.tv_english);
        tv_sindh=(TextView)view.findViewById(R.id.tv_sindhi);

        tv_rhyme_play_screen.setText(getString(BAL.list.get(Util.rhyme_selected_position).getRhyme()));
        tv_rhyme_play_screen.setMovementMethod(new ScrollingMovementMethod());

        tv_sindh.setText(BAL.list.get(Util.rhyme_selected_position).getName_sindhi());
        tv_eng.setText(BAL.list.get(Util.rhyme_selected_position).getName_eng());

        scrollView2.setBackgroundResource(BAL.list.get(Util.rhyme_selected_position).getImage());




        utils = new Utilities();
        mPlayer = MediaPlayer.create(getActivity(), BAL.list.get(Util.rhyme_selected_position).getRhyme_mp3());



        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.e("++_+++",""+mp.getCurrentPosition());
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isPlaying==false){
                    isPlaying=true;
                    mPlayer.start();
                    btn_play.setBackgroundResource(R.mipmap.icon_pause);
                    myHandler.postDelayed(UpdateSongTime,100);
                }
                else {
                    mPlayer.pause();
                    btn_play.setBackgroundResource(R.mipmap.icon_play);
                    isPlaying=false;
                }

            }
        });





        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPlayer.pause();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPlayer.stop();

    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {

            long totalDuration = mPlayer.getDuration();
            long currentDuration = mPlayer.getCurrentPosition();

            // Updating progress bar
            int progress = (int)(utils.getProgressPercentage(currentDuration, totalDuration));
            //Log.d("Progress", ""+progress);
            seekbar.setProgress(progress);

            // Running this thread after 100 milliseconds
            myHandler.postDelayed(this, 100);


        }
    };




}
