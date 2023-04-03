package com.example.sindhilearning.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.AdapterAlphaQuiz;
import com.example.sindhilearning.adapters.AdapterLessonAlpha;
import com.example.sindhilearning.beans.AlphabetQuizBean;
import com.example.sindhilearning.beans.LessionBean;
import com.example.sindhilearning.classes.Util;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;

public class AlphabetFrag extends Fragment {


    public static TextView tv_ans;
    ArrayList<LessionBean> list;
    RecyclerView lst_option, lst_option_quiz;
    TextView tv_english, tv_sindhi;
    ImageView iv_image;
    RecyclerViewClickListener listener = null;
    RecyclerViewClickListener listener_quiz = null;
    MediaPlayer mPlayer;
    TextView tv_quiz_sindhi;
    ImageView iv_quiz_image;
    private int level = 0;
    private int level_quiz = 0;
    int index = 0;
    LinearLayout ll_lesson;
    RelativeLayout rl_bottom;
    TextView tv_final_Score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alphabet, container, false);
        lst_option = (RecyclerView) view.findViewById(R.id.lst_option);
        lst_option_quiz = (RecyclerView) view.findViewById(R.id.lst_option_quiz);
        tv_english = (TextView) view.findViewById(R.id.tv_english);
        tv_sindhi = (TextView) view.findViewById(R.id.tv_sindhi);
        iv_image = (ImageView) view.findViewById(R.id.iv_image);
        tv_ans = (TextView) view.findViewById(R.id.et_ans);
        tv_quiz_sindhi = (TextView) view.findViewById(R.id.tv_quiz_sindh);
        iv_quiz_image = (ImageView) view.findViewById(R.id.iv_quiz_image);
        ll_lesson=(LinearLayout)view.findViewById(R.id.ll_lesson);
        rl_bottom=(RelativeLayout) view.findViewById(R.id.rl_bottom);
        tv_final_Score=(TextView) view.findViewById(R.id.tv_final_Score);


        setUpAlphabet();
        setUpQuizData();


        listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                //Toast.makeText(getActivity(),""+list.get(position).getLetter(),Toast.LENGTH_SHORT).show();
                ArrayList<LessionBean> list = Util.getLevel(level);
                mPlayer = MediaPlayer.create(getActivity(), Util.getLevel(level).get(position).getSound());
                if (!mPlayer.isPlaying()) {
                    mPlayer.start();
                }
                Util.getLevel(level).set(position, new LessionBean(position, list.get(position).getLetter()
                        , list.get(position).getImage()
                        , list.get(position).getSound()
                        , list.get(position).getSindhi()
                        , list.get(position).getEnglish()
                        , true));
                update(list, position);
                if (level < Util.lessonLevelBeans.size() - 1) {
                    if (checkIsCompleted(Util.getLevel(level))) {
                        level++;
                        setNextLevel(level, listener);
                        //update(Util.getLevel(level), 0);
                        Toast.makeText(getActivity(), "completed, next Started", Toast.LENGTH_SHORT).show();
                        hideLession();
                        showQuiz();

                    }
                } else {
                    Toast.makeText(getActivity(), "All Levels Are completed!", Toast.LENGTH_SHORT).show();
                    hideLession();
                    showQuiz();
                }
                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout, new RhymesDetailFrag()).addToBackStack(null).commit();
            }
        };


        //-------quiz-----------------------------

        listener_quiz = new RecyclerViewClickListener() {


            @Override
            public void onClick(View view, int position) {

                if (Util.getQuizLevel(level_quiz).get(index).getOptions()[position].equalsIgnoreCase(Util.getQuizLevel(level_quiz).get(index).getAnswer())) {
                    Toast.makeText(getActivity(), "Right Answer", Toast.LENGTH_SHORT).show();
                    tv_ans.setText("" + Util.getQuizLevel(level_quiz).get(index).getAnswer());
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.are_wah);if (!mPlayer.isPlaying()) {mPlayer.start();}

                    Util.alpha_quiz_score+=5;
                } else {
                    Toast.makeText(getActivity(), "WRONG Answer", Toast.LENGTH_SHORT).show();
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.wrong);if (!mPlayer.isPlaying()) {mPlayer.start();}tv_ans.setText("Galat");
                }
                Util.getQuizLevel(level_quiz).set(index, new AlphabetQuizBean(Util.getQuizLevel(level_quiz).get(index).getId(), Util.getQuizLevel(level_quiz).get(index).getSindhi(), Util.getQuizLevel(level_quiz).get(index).getEnglish(), Util.getQuizLevel(level_quiz).get(index).getImage(), Util.getQuizLevel(level_quiz).get(index).getOptions(), Util.getQuizLevel(level_quiz).get(index).getAnswer(), true));
                index++;


                if (level_quiz < Util.quizLevelBeans.size() - 1) {

                    if (isQuizLevelCompleted(Util.getQuizLevel(level_quiz))) {
                        level_quiz++;
                        index = 0;
                        updateQuiz(listener_quiz, level_quiz, index);
                        Toast.makeText(getActivity(), "Level Complete", Toast.LENGTH_SHORT).show();
                        hideQuiz();
                        showLession();
                    }
                    else {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                updateQuiz(listener_quiz, level_quiz, index);
                            }
                        }, 2000);

                    }
                }
                else {
                    Toast.makeText(getActivity(), "all Levels Complete", Toast.LENGTH_SHORT).show();
                    endQuiz();
                }





            }
        };



        setNextLevel(0, listener);
        updateQuiz(listener_quiz, level_quiz, 0);

        showLession();
        hideQuiz();

        return view;
    }


    //-------------- show hide game

    private void hideLession(){
        tv_english.setVisibility(View.GONE);
        tv_sindhi.setVisibility(View.GONE);
        iv_image.setVisibility(View.GONE);
        lst_option.setVisibility(View.GONE);
        ll_lesson.setVisibility(View.GONE);
        rl_bottom.setVisibility(View.GONE);

    }

    private void showLession(){
        tv_english.setVisibility(View.VISIBLE);
        tv_sindhi.setVisibility(View.VISIBLE);
        iv_image.setVisibility(View.VISIBLE);
        lst_option.setVisibility(View.VISIBLE);
        ll_lesson.setVisibility(View.VISIBLE);
        rl_bottom.setVisibility(View.VISIBLE);
    }

    private void hideQuiz(){
        iv_quiz_image.setVisibility(View.GONE);
        tv_quiz_sindhi.setVisibility(View.GONE);
        tv_ans.setVisibility(View.GONE);
        lst_option_quiz.setVisibility(View.GONE);

    }

    private void showQuiz(){
        iv_quiz_image.setVisibility(View.VISIBLE);
        tv_quiz_sindhi.setVisibility(View.VISIBLE);
        tv_ans.setVisibility(View.VISIBLE);
        lst_option_quiz.setVisibility(View.VISIBLE);
    }

    private void endQuiz(){
        hideLession();
        hideQuiz();
        tv_final_Score.setVisibility(View.VISIBLE);
        tv_final_Score.setText("Score is:"+Util.alpha_quiz_score);
    }


    //-----------------


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setUpAlphabet() {
        ArrayList<LessionBean> level1 = new ArrayList<>();
        level1.add(new LessionBean(3, "ٻ", R.drawable.c, R.raw.bey_bili, "ٻلي", "Cat", false));
        level1.add(new LessionBean(2, "ب", R.drawable.b, R.raw.bey_badaq, "بدڪ", "Duck", false));
        level1.add(new LessionBean(1, "ا", R.drawable.a, R.raw.alif, "انب", "Mango", false));
        level1.add(new LessionBean(6, "ٿ", R.drawable.f, R.raw.thye_thelo, "ٿيلهو", "Bag", false));
        level1.add(new LessionBean(5, "ت", R.drawable.e, R.raw.te_taaro, "تارو", "Star", false));
        level1.add(new LessionBean(4, "ڀ", R.drawable.d, R.raw.bhey_bhit, "ڀت", "Wall", false));
        Util.addLevel(level1);


        ArrayList<LessionBean> level2 = new ArrayList<>();
        level2.add(new LessionBean(3, "ث", R.drawable.i, R.raw.say_samar, "ثمر", "Fruit", false));
        level2.add(new LessionBean(2, "ٺ", R.drawable.h, R.raw.they_thoth, "ٺوٺ", "Elbow", false));
        level2.add(new LessionBean(1, "ٽ", R.drawable.g, R.raw.tey_topi, "ٽوپي", "Cap", false));
        level2.add(new LessionBean(6, "ڄ", R.drawable.l, R.raw.jye_jhib, "ڄڀ", "Tongue", false));
        level2.add(new LessionBean(5, "ج", R.drawable.k, R.raw.jem_jahaz, "جهاز", "Airplane", false));
        level2.add(new LessionBean(4, "پ", R.drawable.j, R.raw.pay_pagh, "پڳ", "Head", false));
        Util.addLevel(level2);


        ArrayList<LessionBean> level3 = new ArrayList<>();
        level3.add(new LessionBean(3, "چ", R.drawable.o, R.raw.chay_chand, "چنڊ", "Moon", false));
        level3.add(new LessionBean(2, "ڃ", R.drawable.n, R.raw.jye_janj, "ڄڃ", "Crowd", false));
        level3.add(new LessionBean(1, "جھ", R.drawable.m, R.raw.jhay_jhirki, "جهرڪي", "Sparrow", false));
        level3.add(new LessionBean(6, "خ", R.drawable.r, R.raw.khay_khat, "خط", "Letter", false));
        level3.add(new LessionBean(5, "ح", R.drawable.q, R.raw.hey_huko, "ھجم", "Barber", false));
        level3.add(new LessionBean(4, "ڇ", R.drawable.p, R.raw.chay_chatri, "ڇٽي", "Umbrella", false));
        Util.addLevel(level3);

        ArrayList<LessionBean> level4 = new ArrayList<>();
        ///check images e.g : s, t
        level4.add(new LessionBean(3, "ڏ", R.drawable.v, R.raw.dey_dedar, "ڏيڏرُ", "Frog", false));
        level4.add(new LessionBean(2, "ڌ", R.drawable.u, R.raw.dhe_dhobi, "ڌوٻيُ", "Landry man", false));
        level4.add(new LessionBean(1, "د", R.drawable.st, R.raw.daal_dar, "درُ", "Door", false));
        level4.add(new LessionBean(6, "ذ", R.drawable.y, R.raw.zaal_zaro, "ذرو", "Piece", false));
        level4.add(new LessionBean(5, "ڍ", R.drawable.x, R.raw.dhe_dhago, "ڍڳو", "Cow", false));
        level4.add(new LessionBean(4, "ڊ", R.drawable.w, R.raw.dre_drakh, "ڊاک", "Graps", false));
        Util.addLevel(level4);


        ArrayList<LessionBean> level5 = new ArrayList<>();
        //add sindhi for train
        level5.add(new LessionBean(3, "ز", R.drawable.ac, R.raw.z_zanjir, "زنجير", "Chain", false));
        level5.add(new LessionBean(2, "ڙ", R.drawable.ab, R.raw.ray_mari, "ماڙي", "Building", false));
        level5.add(new LessionBean(1, "ر", R.drawable.z, R.raw.rey_rail, "ٻلي", "Train", false));
        level5.add(new LessionBean(6, "ص", R.drawable.af, R.raw.saad_soof, "صوف", "Apple", false));
        level5.add(new LessionBean(5, "ش", R.drawable.ae, R.raw.sheen_shenh, "شينهُن", "Lion", false));
        level5.add(new LessionBean(4, "س", R.drawable.ad, R.raw.seen_sij, "سج", "Sun", false));
        Util.addLevel(level5);

        ArrayList<LessionBean> level6 = new ArrayList<>();
        level6.add(new LessionBean(3, "ظ", R.drawable.ai, R.raw.zue_zalim, "ظالم", "Mango", false));
        level6.add(new LessionBean(2, "ط", R.drawable.ah, R.raw.tue_toto, "طوطو", "Parote", false));
        level6.add(new LessionBean(1, "ض", R.drawable.ag, R.raw.zuaad_zaeef, "ضعيف", "Old men", false));
        level6.add(new LessionBean(6, "ف", R.drawable.al, R.raw.fey_fauji, "فوجي", "Soldier", false));
        level6.add(new LessionBean(5, "غ", R.drawable.ak, R.raw.gain_galeecho, "غاليچو", "Mate", false));
        level6.add(new LessionBean(4, "ع", R.drawable.aj, R.raw.ain_ainak, "عينڪ", "Glasses", false));
        Util.addLevel(level6);

        ArrayList<LessionBean> level7 = new ArrayList<>();
        level7.add(new LessionBean(3, "ڪ", R.drawable.ao, R.raw.k_kuto, "ڪتو", "Dog", false));
        level7.add(new LessionBean(2, "ق", R.drawable.an, R.raw.kaf_qalam, "قلم", "Pen", false));
        level7.add(new LessionBean(1, "ڦ", R.drawable.am, R.raw.fai_feetho, "ڦيٿو", "Wheel", false));

        //check
        level7.add(new LessionBean(6, "ڳ", R.drawable.ar, R.raw.gh_ghao, "ڳيرو", "Ringdove", false));
        level7.add(new LessionBean(5, "گ", R.drawable.aq, R.raw.gaaf_gudi, "گڏھ", "Donkey", false));
        level7.add(new LessionBean(4, "ک", R.drawable.ap, R.raw.khay_khat, "کٽ", "Cot", false));
        Util.addLevel(level7);

        ArrayList<LessionBean> level8 = new ArrayList<>();
        level8.add(new LessionBean(3, "ل", R.drawable.au, R.raw.lam_lagar, "لغڙ", "Kite", false));
        level8.add(new LessionBean(2, "ڱ", R.drawable.at, R.raw.nye_sing, "سڱ", "Horns", false));
        level8.add(new LessionBean(1, "گھ", R.drawable.as, R.raw.ghey_ghoro, "گھوڙو", "Hours", false));
        level8.add(new LessionBean(6, "ڻ", R.drawable.ax, R.raw.nun_war, "وڻ", "Tree", false));
        level8.add(new LessionBean(5, "ن", R.drawable.aw, R.raw.nun_nath, "نٿ", "nose ring", false));
        level8.add(new LessionBean(4, "م", R.drawable.av, R.raw.mem_machi, "مڇي", "Fish", false));
        Util.addLevel(level8);

        ArrayList<LessionBean> level9 = new ArrayList<>();
        //check image for mother
        level9.add(new LessionBean(3, "ء", R.drawable.bd, R.raw.alif_wao, "ما", "Mother", false));
        level9.add(new LessionBean(2, "ھ", R.drawable.az, R.raw.hey_hath, "ھٿ", "Hand", false));
        level9.add(new LessionBean(1, "و", R.drawable.ay, R.raw.wao_wadhu, "واڄو", "Musical instrument", false));
        level9.add(new LessionBean(4, "ي", R.drawable.bc, R.raw.ye_yaqtaro, "يڪتارو", "Tempura", false));
        Util.addLevel(level9);

    }

    private void update(ArrayList<LessionBean> lessionBeans, int position) {
        iv_image.setImageResource(lessionBeans.get(position).getImage());
        tv_sindhi.setText("" + lessionBeans.get(position).getSindhi());
        tv_english.setText("" + lessionBeans.get(position).getEnglish());
    }

    private boolean checkIsCompleted(ArrayList<LessionBean> lessionBeans) {
        boolean isCom = false;
        int count = 0;
        for (LessionBean bean : lessionBeans) {
            if (bean.isClicked()) {
                count++;
            } else {
                count--;
            }
        }
        if (count == lessionBeans.size())
            isCom = true;
        return isCom;
    }


    private void setNextLevel(int level, RecyclerViewClickListener mListener) {
        AdapterLessonAlpha adapter = new AdapterLessonAlpha(getActivity(), mListener, Util.getLevel(level));
        lst_option.setHasFixedSize(true);
        lst_option.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        lst_option.setAdapter(adapter);

    }

    //--------------- quiz
    private boolean isQuizLevelCompleted(ArrayList<AlphabetQuizBean> alphabetQuizBeans) {
        boolean isCom = false;
        int count = 0;
        for (AlphabetQuizBean bean : alphabetQuizBeans) {
            if (bean.isCompleted()) {
                count++;
            } else {
                count--;
            }
        }
        if (count == alphabetQuizBeans.size())
            isCom = true;

        Log.e("++_+++++",""+isCom);
        return isCom;
    }

    private void updateQuiz(RecyclerViewClickListener mListener, int level_quiz, int index) {
        Log.d("++_+++", "updateQuiz:");
        Log.d("++_+++", "level:" + level_quiz);
        Log.d("++_+++", "index:" + index);

        tv_ans.setText("");
        tv_quiz_sindhi.setText("" + Util.getQuizLevel(level_quiz).get(index).getSindhi());
        iv_quiz_image.setImageResource(Util.getQuizLevel(level_quiz).get(index).getImage());

        AdapterAlphaQuiz adapter = new AdapterAlphaQuiz(mListener, Util.getQuizLevel(level_quiz).get(index).getOptions());
        lst_option_quiz.setHasFixedSize(true);
        lst_option_quiz.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        lst_option_quiz.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void setUpQuizData() {
        ArrayList<AlphabetQuizBean> quiz1 = new ArrayList<>();
        String opt1_1[] = {"ٻ", "ا", "ب"};
        String opt1_2[] = {"ب", "ٻ", "ا"};
        String opt1_3[] = {"ڀ", "ٻ", "ب"};
        String opt1_4[] = {"ڀ", "ٻ", "ت"};
        String opt1_5[] = {"ٿ", "ڀ", "ت"};
        String opt1_6[] = {"ا", "ٿ", "ت"};

        quiz1.add(new AlphabetQuizBean(1, "انب", "Mango", R.drawable.a, opt1_1, "ا", false));
        quiz1.add(new AlphabetQuizBean(2, "بدڪ", "Dukh", R.drawable.b, opt1_2, "ب", false));
        quiz1.add(new AlphabetQuizBean(3, "ٻلي", "Cat", R.drawable.c, opt1_3, "ٻ", false));
        quiz1.add(new AlphabetQuizBean(4, "ڀت", "Wall", R.drawable.d, opt1_4, "ڀ", false));
        quiz1.add(new AlphabetQuizBean(5, "تارو", "Star", R.drawable.e, opt1_5, "ت", false));
        quiz1.add(new AlphabetQuizBean(5, "ٿيلهو", "Bag", R.drawable.f, opt1_6, "ٿ", false));
        Util.addQuizLevel(quiz1);

        ArrayList<AlphabetQuizBean> quiz2 = new ArrayList<>();
        String opt2_1[] = {"ث", "ٺ", "ٽ"};
        String opt2_2[] = {"ٺ", "ث", "ٽ"};
        String opt2_3[] = {"پ", "ڄ", "ث"};
        String opt2_4[] = {"ث", "پ", "ڄ"};
        String opt2_5[] = {"ٽ", "ج", "ث"};
        String opt2_6[] = {"ج", "ث", "ڄ"};
        quiz2.add(new AlphabetQuizBean(1, "ٽوپي", "Cap", R.drawable.g, opt2_1, "ٽ", false));
        quiz2.add(new AlphabetQuizBean(2, "ٺوٺ", "Elbow", R.drawable.h, opt2_2, "ٺ", false));
        quiz2.add(new AlphabetQuizBean(3, "ثمر", "Fruit", R.drawable.i, opt2_3, "ث", false));
        quiz2.add(new AlphabetQuizBean(4, "پڳ", "Head", R.drawable.j, opt2_4, "پ", false));
        quiz2.add(new AlphabetQuizBean(5, "جهاز", "Airplan", R.drawable.k, opt2_5, "ج", false));
        quiz2.add(new AlphabetQuizBean(5, "ڄڀ", "Tongue", R.drawable.l, opt2_6, "ڄ", false));
        Util.addQuizLevel(quiz2);

        ArrayList<AlphabetQuizBean> quiz3 = new ArrayList<>();
        String opt3_1[] = {"ڄ", "چ", "جه"};
        String opt3_2[] = {"ھ", "ڇ", "ڄ"};
        String opt3_3[] = {"چ", "خ", "ھ"};
        String opt3_4[] = {"ھ", "ڇ", "جه"};
        String opt3_5[] = {"جه", "خ", "ھ"};
        String opt3_6[] = {"ڇ", "جه", "خ"};
        quiz3.add(new AlphabetQuizBean(1, "جهرڪي", "Sparrow", R.drawable.m, opt3_1, "جھ", false));
        quiz3.add(new AlphabetQuizBean(2, "ڄڃ", "Crowd", R.drawable.n, opt3_2, "ڃ", false));
        quiz3.add(new AlphabetQuizBean(3, "چنڊ", "Moon", R.drawable.o, opt3_3, "چ", false));
        quiz3.add(new AlphabetQuizBean(4, "ڇٽي", "Umbrella", R.drawable.p, opt3_4, "ڇ", false));
        quiz3.add(new AlphabetQuizBean(5, "ھجم", "Barber", R.drawable.q, opt3_5, "ح", false));
        quiz3.add(new AlphabetQuizBean(5, "خط", "Letter", R.drawable.r, opt3_6, "خ", false));
        Util.addQuizLevel(quiz3);


        ArrayList<AlphabetQuizBean> quiz4 = new ArrayList<>();
        String opt4_1[] = {"ڏ", "د", "ذ"};
        String opt4_2[] = {"د", "ڏ", "ڌ"};
        String opt4_3[] = {"ڌ", "ڏ", "ڊ"};
        String opt4_4[] = {"د", "ڌ", "ڊ"};
        String opt4_5[] = {"ڊ", "ڍ", "د"};
        String opt4_6[] = {"ڊ", "ڍ", "ذ"};
        quiz4.add(new AlphabetQuizBean(1, "درُ", "Door", R.drawable.st, opt4_1, "د", false));
        quiz4.add(new AlphabetQuizBean(2, "ڌوٻيُ", "Landry Man", R.drawable.u, opt4_2, "ڌ", false));
        quiz4.add(new AlphabetQuizBean(3, "ڏيڏرُ", "Frog", R.drawable.v, opt4_3, "ڏ", false));
        quiz4.add(new AlphabetQuizBean(4, "ڊاک", "Graps", R.drawable.w, opt4_4, "ڊ", false));
        quiz4.add(new AlphabetQuizBean(5, "ڍڳو", "Cow", R.drawable.x, opt4_5, "ڍ", false));
        quiz4.add(new AlphabetQuizBean(5, "ذرو", "Piece", R.drawable.y, opt4_6, "ذ", false));
        Util.addQuizLevel(quiz4);

        ArrayList<AlphabetQuizBean> quiz5 = new ArrayList<>();
        String opt5_1[] = {"ز", "ر", "م"};
        String opt5_2[] = {"م", "ر", "س"};
        String opt5_3[] = {"", "س", "ز"};
        String opt5_4[] = {"ز", "ر", "س"};
        String opt5_5[] = {"ش", "ص", "س"};
        String opt5_6[] = {"م", "ص", "ز"};
        quiz5.add(new AlphabetQuizBean(1, "ري", "Train", R.drawable.z, opt5_1, "ر", false));
        quiz5.add(new AlphabetQuizBean(2, "ماڙي", "Building", R.drawable.ab, opt5_2, "م", false));
        quiz5.add(new AlphabetQuizBean(3, "زنجير", "Chain", R.drawable.ac, opt5_3, "ز", false));
        quiz5.add(new AlphabetQuizBean(4, "سج", "Sun", R.drawable.ad, opt5_4, "س", false));
        quiz5.add(new AlphabetQuizBean(5, "شينهُن", "Lion", R.drawable.ae, opt5_5, "ش", false));
        quiz5.add(new AlphabetQuizBean(5, "صوف", "Apple", R.drawable.af, opt5_6, "ص", false));
        Util.addQuizLevel(quiz5);


        ArrayList<AlphabetQuizBean> quiz6 = new ArrayList<>();
        String opt6_1[] = {"ظ", "ض", "ط"};
        String opt6_2[] = {"ض", "", "ط"};
        String opt6_3[] = {"ف", "ظ", "ع"};
        String opt6_4[] = {"ع", "غ", "ض"};
        String opt6_5[] = {"ف", "غ", "ع"};
        String opt6_6[] = {"غ", "ف", "ط"};
        quiz6.add(new AlphabetQuizBean(1, "ضعيف", "Old Man", R.drawable.ag, opt6_1, "ض", false));
        quiz6.add(new AlphabetQuizBean(2, "طوطو", "Parot", R.drawable.ah, opt6_2, "ط", false));
        quiz6.add(new AlphabetQuizBean(3, "ظالم", "ZZ", R.drawable.ai, opt6_3, "ظ", false));
        quiz6.add(new AlphabetQuizBean(4, "عينڪ", "Glasses", R.drawable.aj, opt6_4, "ع", false));
        quiz6.add(new AlphabetQuizBean(5, "غاليچو", "Mate", R.drawable.ak, opt6_5, "غ", false));
        quiz6.add(new AlphabetQuizBean(5, "فوجي", "Soldier", R.drawable.al, opt6_6, "ف", false));
        Util.addQuizLevel(quiz6);

        ArrayList<AlphabetQuizBean> quiz7 = new ArrayList<>();
        String opt7_1[] = {"ڪ", "ڦ", "ق"};
        String opt7_2[] = {"ڦ", "ڪ", "ق"};
        String opt7_3[] = {"گ", "ڪ", "ک"};
        String opt7_4[] = {"ق", "گ", "ک"};
        String opt7_5[] = {"ک", "گ", "ڳ"};
        String opt7_6[] = {"ڦ", "ق", "ڳ"};
        quiz7.add(new AlphabetQuizBean(1, "ڦيٿو", "Wheel", R.drawable.am, opt7_1, "ڦ", false));
        quiz7.add(new AlphabetQuizBean(2, "قلم", "Pen", R.drawable.an, opt7_2, "ق", false));
        quiz7.add(new AlphabetQuizBean(3, "ڪتو", "Dog", R.drawable.ao, opt7_3, "ڪ", false));
        quiz7.add(new AlphabetQuizBean(4, "کٽ", "Cot", R.drawable.ap, opt7_4, "ک", false));
        quiz7.add(new AlphabetQuizBean(5, "گڏھ", "Donkey", R.drawable.aq, opt7_5, "گ", false));
        quiz7.add(new AlphabetQuizBean(5, "ڳيرو", "Ringdove", R.drawable.ar, opt7_6, "ڳ", false));
        Util.addQuizLevel(quiz7);

        ArrayList<AlphabetQuizBean> quiz8 = new ArrayList<>();
        String opt8_1[] = {"ل", "گھ", "س"};
        String opt8_2[] = {"م", "س", "گھ"};
        String opt8_3[] = {"ن", "گھ", "ل"};
        String opt8_4[] = {"م", "ل", "س"};
        String opt8_5[] = {"ل", "م", "ن"};
        String opt8_6[] = {"ن", "و", "س"};
        quiz8.add(new AlphabetQuizBean(1, "گھوڙو", "Horse", R.drawable.as, opt8_1, "گھ", false));
        quiz8.add(new AlphabetQuizBean(2, "سڱ", "Horns", R.drawable.at, opt8_2, "س", false));
        quiz8.add(new AlphabetQuizBean(3, "لغڙ", "Kite", R.drawable.au, opt8_3, "ل", false));
        quiz8.add(new AlphabetQuizBean(4, "مڇي", "Fish", R.drawable.av, opt8_4, "م", false));
        quiz8.add(new AlphabetQuizBean(5, "نٿ", "Nose Ring", R.drawable.aw, opt8_5, "ن", false));
        quiz8.add(new AlphabetQuizBean(5, "وڻ", "Tree", R.drawable.ax, opt8_6, "و", false));
        Util.addQuizLevel(quiz8);

        ArrayList<AlphabetQuizBean> quiz9 = new ArrayList<>();
        String opt9_1[] = {"ء", "و", "ھ"};
        String opt9_2[] = {"و", "ء", "ھ"};
        String opt9_3[] = {"ھ", "ي", "ء"};
        String opt9_4[] = {"و", "ي", "ھ"};
        quiz9.add(new AlphabetQuizBean(1, "واڄو", "Musical instrument", R.drawable.ay, opt9_1, "و", false));
        quiz9.add(new AlphabetQuizBean(2, "ھٿ", "Hand", R.drawable.az, opt9_2, "ھ", false));
        quiz9.add(new AlphabetQuizBean(3, "ماء", "Mother", R.drawable.bd, opt9_3, "ء", false));
        quiz9.add(new AlphabetQuizBean(4, "يڪتارو", "Tempura", R.drawable.bc, opt9_4, "ي", false));

        Util.addQuizLevel(quiz9);
    }


    //----------------------quiz end


}
