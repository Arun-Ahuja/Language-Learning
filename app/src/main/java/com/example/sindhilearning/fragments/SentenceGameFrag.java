package com.example.sindhilearning.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.AdaperSentenceGameOptions;
import com.example.sindhilearning.beans.OptionsBean;
import com.example.sindhilearning.beans.SentenceGameBean;
import com.example.sindhilearning.classes.BAL;
import com.example.sindhilearning.classes.Util;

import java.util.ArrayList;


public class SentenceGameFrag extends Fragment {

    GridView lst_option;
    ArrayList<SentenceGameBean> sentenceGameBeans;
    int index = 0, wrong_count = 0, score = 0;
    AdaperSentenceGameOptions adaper;
    private TextView txt_sindhi_english, tv_question, txt_current_quetion, txt_current_score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sentence_game2, container, false);
        lst_option = (GridView) view.findViewById(R.id.lst_option);
        txt_sindhi_english = (TextView) view.findViewById(R.id.txt_sindhi_english);
        tv_question = (TextView) view.findViewById(R.id.tv_question);
        txt_current_quetion = (TextView) view.findViewById(R.id.txt_current_quetion);
        txt_current_score = (TextView) view.findViewById(R.id.txt_current_score);

        setData();

        txt_sindhi_english.setText("" + sentenceGameBeans.get(index).getQuestion_eng());
        tv_question.setText("" + sentenceGameBeans.get(index).getQuestion());

        adaper = new AdaperSentenceGameOptions(sentenceGameBeans.get(0).getOptions(), getActivity());
        lst_option.setAdapter(adaper);

        lst_option.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(),""+sentenceGameBeans.get(index).getOptions().get(position).getOption(),Toast.LENGTH_SHORT).show();


                if (isQuestionsContinue()) {
                    String option = sentenceGameBeans.get(index).getOptions().get(position).getOption();
                    String answer = sentenceGameBeans.get(index).getAnswer();
                    if (option.equalsIgnoreCase(answer)) {
                        MediaPlayer mPlayer = MediaPlayer.create(getActivity(), R.raw.are_wah);
                        mPlayer.start();

                        adaper.answer = 1;
                        adaper.pos = position;
                        adaper.notifyDataSetChanged();
                        tv_question.setText(sentenceGameBeans.get(index).getComplete_question());

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                setNextQuestion();
                            }
                        }, 2000);


                    } else {
                        MediaPlayer mPlayer = MediaPlayer.create(getActivity(), R.raw.wrong);
                        mPlayer.start();
                        Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        // Vibrate for 500 milliseconds
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            //deprecated in API 26
                            v.vibrate(500);
                        }
                        adaper.answer = 0;
                        wrong_count++;
                    }
                } else {
                    Toast.makeText(getActivity(), "Quiz Complete", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Quiz Complete \n Your Score: "+score)
                            .setMessage("Your Score is Do you want to Play it again?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    resetGame();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.layout, new DashBoardFrag());
                            fragmentTransaction.commit();
                        }
                    })

                            .setIcon(R.drawable.logo)
                            .show();
                }
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

    private void setNextQuestion() {
        index++;
        txt_sindhi_english.setText(sentenceGameBeans.get(index).getQuestion_eng());
        tv_question.setText(sentenceGameBeans.get(index).getQuestion());
        lst_option.setAdapter(new AdaperSentenceGameOptions(sentenceGameBeans.get(index).getOptions(), getActivity()));
        txt_current_quetion.setText((index + 1) + "/15");

        if (wrong_count == 0) {
            score += 5;
        } else if (wrong_count == 1) {
            score += 4;
        } else if (wrong_count == 2) {
            score += 3;
        } else if (wrong_count == 3) {
            score += 2;
        } else {
            score += 1;
        }
        txt_current_score.setText("" + score);
        wrong_count = 0;
    }

    private boolean isQuestionsContinue() {
        if (index < sentenceGameBeans.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    private void setData() {
        sentenceGameBeans = new ArrayList<>();
        ArrayList<OptionsBean> optionsBean1 = new ArrayList<>();
        optionsBean1.add(new OptionsBean(1, "اُڏامي"));
        optionsBean1.add(new OptionsBean(2, "سڙي"));
        optionsBean1.add(new OptionsBean(3, "پڪڙي"));
        optionsBean1.add(new OptionsBean(4, "ڊوڙي"));
        sentenceGameBeans.add(new SentenceGameBean(1, "ڄڀ ........ ٿي", "ڄڀ سڙي ٿي", "Tongue is burning", "سڙي", optionsBean1));

        ArrayList<OptionsBean> optionsBean2 = new ArrayList<>();
        optionsBean2.add(new OptionsBean(1, "ٿي"));
        optionsBean2.add(new OptionsBean(1, "پي"));
        optionsBean2.add(new OptionsBean(1, "ٿو"));
        optionsBean2.add(new OptionsBean(1, "آھي"));
        sentenceGameBeans.add(new SentenceGameBean(2, "ھوائي جھاز اُڏامي........", "ھوائي جھاز اُڏامي ٿو", "Aeroplane flies", "ٿو", optionsBean2));


        ArrayList<OptionsBean> optionsBean3 = new ArrayList<>();
        optionsBean3.add(new OptionsBean(1, "ٿو"));
        optionsBean3.add(new OptionsBean(1, "ڏي"));
        optionsBean3.add(new OptionsBean(1, "آھي"));
        optionsBean3.add(new OptionsBean(1, "ٿي"));
        sentenceGameBeans.add(new SentenceGameBean(3, "بس اچي........", "بس اچي ٿي", "Bus is coming", "ٿي", optionsBean3));

        ArrayList<OptionsBean> optionsBean4 = new ArrayList<>();
        optionsBean4.add(new OptionsBean(1, "وزن"));
        optionsBean4.add(new OptionsBean(1, "لڪڻ"));
        optionsBean4.add(new OptionsBean(1, "تارو"));
        optionsBean4.add(new OptionsBean(1, "وڻ"));
        sentenceGameBeans.add(new SentenceGameBean(4, "گڏھُ........کڻي ٿو", "گڏھ وزن کڻي ٿو", "Donkey carries weight", "وزن", optionsBean4));

        ArrayList<OptionsBean> optionsBean5 = new ArrayList<>();
        optionsBean5.add(new OptionsBean(1, "آھي"));
        optionsBean5.add(new OptionsBean(1, "آھن"));
        optionsBean5.add(new OptionsBean(1, "ويا"));
        optionsBean5.add(new OptionsBean(1, "ٿو"));
        sentenceGameBeans.add(new SentenceGameBean(5, "ڏھ طوطا پري اُڏامي........", "ڏھ طوطا پري اُڏامي ويا", "Ten parrots flew far away", "ويا", optionsBean5));

        ArrayList<OptionsBean> optionsBean6 = new ArrayList<>();
        optionsBean6.add(new OptionsBean(1, "ڊوڙن"));
        optionsBean6.add(new OptionsBean(1, "رُڪن"));
        optionsBean6.add(new OptionsBean(1, "ويھن"));
        optionsBean6.add(new OptionsBean(1, "اُڏامن"));
        sentenceGameBeans.add(new SentenceGameBean(6, "گھوڙا تيز پيا........", "گھوڙا تيز پيا ڊوڙن", "Horses are running fast", "ڊوڙن", optionsBean6));

        ArrayList<OptionsBean> optionsBean7 = new ArrayList<>();
        optionsBean7.add(new OptionsBean(1, "ڀاڄي"));
        optionsBean7.add(new OptionsBean(1, "چانھ"));
        optionsBean7.add(new OptionsBean(1, "پاڻي"));
        optionsBean7.add(new OptionsBean(1, "کير"));
        sentenceGameBeans.add(new SentenceGameBean(1, "وڻ کي........ڏي", "وڻ کي پاڻي ڏي", "Give water to tree", "پاڻي", optionsBean7));

        ArrayList<OptionsBean> optionsBean8 = new ArrayList<>();
        optionsBean8.add(new OptionsBean(1, "تارا"));
        optionsBean8.add(new OptionsBean(1, "اَچُ"));
        optionsBean8.add(new OptionsBean(1, "رکُ"));
        optionsBean8.add(new OptionsBean(1, "وزنُ"));
        sentenceGameBeans.add(new SentenceGameBean(1, "ھتي..........", "ھتي اَچُ", "Come here", "اَچُ", optionsBean8));

        ArrayList<OptionsBean> optionsBean9 = new ArrayList<>();
        optionsBean9.add(new OptionsBean(1, "ھا"));
        optionsBean9.add(new OptionsBean(1, "سڙي"));
        optionsBean9.add(new OptionsBean(1, "نَ"));
        optionsBean9.add(new OptionsBean(1, "سُمھي"));
        sentenceGameBeans.add(new SentenceGameBean(9, "گرمُ کيرُ...........پيئُ", "گرمُ کيرُ نَ پيئُ", "Do not drink hot water", "نَ", optionsBean9));

        ArrayList<OptionsBean> optionsBean10 = new ArrayList<>();
        optionsBean10.add(new OptionsBean(1, "قلمُ"));
        optionsBean10.add(new OptionsBean(1, "انب"));
        optionsBean10.add(new OptionsBean(1, "کٽ"));
        optionsBean10.add(new OptionsBean(1, "لڪڻُ"));
        sentenceGameBeans.add(new SentenceGameBean(10, "........کاءُ", "انب کاءُ", "Eat mango", "انب", optionsBean10));

        ArrayList<OptionsBean> optionsBean11 = new ArrayList<>();
        optionsBean11.add(new OptionsBean(1, "وٽ"));
        optionsBean11.add(new OptionsBean(1, "کي"));
        optionsBean11.add(new OptionsBean(1, "تي"));
        optionsBean11.add(new OptionsBean(1, "جو"));
        sentenceGameBeans.add(new SentenceGameBean(11, "شينھن جھنگل........راجا آھي", "شينھن جھنگل جو راجا آھي", "Lion is the king of jungle", "جو", optionsBean11));

        ArrayList<OptionsBean> optionsBean12 = new ArrayList<>();
        optionsBean12.add(new OptionsBean(1, "کيرُ"));
        optionsBean12.add(new OptionsBean(1, "ٻلي"));
        optionsBean12.add(new OptionsBean(1, "طوطو"));
        optionsBean12.add(new OptionsBean(1, "مورُ"));
        sentenceGameBeans.add(new SentenceGameBean(12, "........کاري آھي", "ٻلي کاري آھي", "Cat is black", "ٻلي", optionsBean12));

        ArrayList<OptionsBean> optionsBean13 = new ArrayList<>();
        optionsBean13.add(new OptionsBean(1, "کيرُ"));
        optionsBean13.add(new OptionsBean(1, "پٽاٽو"));
        optionsBean13.add(new OptionsBean(1, "شينھن"));
        optionsBean13.add(new OptionsBean(1, "ٻڪري"));
        sentenceGameBeans.add(new SentenceGameBean(13, "..........ڪمزورُ جانورُ آھي", "ٻڪري ڪمزورُ جانورُ آھي", "Goat is weak animal", "ٻڪري", optionsBean13));

        ArrayList<OptionsBean> optionsBean14 = new ArrayList<>();
        optionsBean14.add(new OptionsBean(1, "پٽاٽو"));
        optionsBean14.add(new OptionsBean(1, "پاڻي"));
        optionsBean14.add(new OptionsBean(1, "کيرُ"));
        optionsBean14.add(new OptionsBean(1, "جھازُ"));
        sentenceGameBeans.add(new SentenceGameBean(14, "............ھڪ ڀاڄي آھي", "پٽاٽو ھڪ ڀاڄي آھي", "Potato is one vegetable", "پٽاٽو", optionsBean14));

        ArrayList<OptionsBean> optionsBean15 = new ArrayList<>();
        optionsBean15.add(new OptionsBean(1, "اچي"));
        optionsBean15.add(new OptionsBean(1, "سھڻو"));
        optionsBean15.add(new OptionsBean(1, "بند"));
        optionsBean15.add(new OptionsBean(1, "کول"));
        sentenceGameBeans.add(new SentenceGameBean(15, "درُ........ڪر", "درُ بند ڪر", "Close the door", "بند", optionsBean15));

    }

    private void resetGame() {
        index=0;
        score=0;
        txt_sindhi_english.setText(sentenceGameBeans.get(0).getQuestion_eng());
        tv_question.setText(sentenceGameBeans.get(0).getQuestion());
        lst_option.setAdapter(new AdaperSentenceGameOptions(sentenceGameBeans.get(0).getOptions(), getActivity()));
        txt_current_quetion.setText("1/15");
        txt_current_score.setText("" + score);

    }
}
