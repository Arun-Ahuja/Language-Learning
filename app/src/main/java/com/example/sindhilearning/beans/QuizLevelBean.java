package com.example.sindhilearning.beans;

import java.util.ArrayList;

/**
 * Created by aliraza on 07/02/2019.
 */

public class QuizLevelBean {

    private boolean isCompleted;
    ArrayList<AlphabetQuizBean> alphabetQuizBeans;


    public QuizLevelBean(boolean isCompleted, ArrayList<AlphabetQuizBean> alphabetQuizBeans) {
        this.isCompleted = isCompleted;
        this.alphabetQuizBeans = alphabetQuizBeans;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public ArrayList<AlphabetQuizBean> getAlphabetQuizBeans() {
        return alphabetQuizBeans;
    }
}
