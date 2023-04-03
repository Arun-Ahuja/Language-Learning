package com.example.sindhilearning.classes;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.AlphabetQuizBean;
import com.example.sindhilearning.beans.LessionBean;
import com.example.sindhilearning.beans.LessonLevelBean;
import com.example.sindhilearning.beans.QuizLevelBean;

import java.util.ArrayList;

/**
 * Created by aliraza on 05/08/2019.
 */

public class Util {
    public static int rhyme_selected_position=0;
    public static int words_index=0;
    public static int alpha_quiz_score=0;

    public static ArrayList<LessonLevelBean> lessonLevelBeans=new ArrayList<>();
    public static ArrayList<QuizLevelBean> quizLevelBeans=new ArrayList<>();


    public static ArrayList<LessionBean> getLevel(int level){
        return lessonLevelBeans.get(level).getLessionBeans();
    }

    public static void addLevel(ArrayList<LessionBean> lessionBeans){
        lessonLevelBeans.add(new LessonLevelBean(false,lessionBeans));
    }


    public static ArrayList<AlphabetQuizBean> getQuizLevel(int index){
        return quizLevelBeans.get(index).getAlphabetQuizBeans();
    }


    public static void addQuizLevel(ArrayList<AlphabetQuizBean> alphabetQuizBeans){
        quizLevelBeans.add(new QuizLevelBean(false,alphabetQuizBeans));
    }










}
