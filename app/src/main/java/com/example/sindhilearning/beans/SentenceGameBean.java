package com.example.sindhilearning.beans;

import java.util.ArrayList;

/**
 * Created by aliraza on 05/15/2019.
 */

public class SentenceGameBean {

    private int id;
    private String question;
    private String complete_question;
    private String question_eng;
    private String answer;

    private ArrayList<OptionsBean> options;

    public SentenceGameBean(int id, String question, String complete_question, String question_eng, String answer, ArrayList<OptionsBean> options) {
        this.id = id;
        this.question = question;
        this.complete_question = complete_question;
        this.question_eng = question_eng;
        this.answer = answer;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getComplete_question() {
        return complete_question;
    }

    public void setComplete_question(String complete_question) {
        this.complete_question = complete_question;
    }

    public String getQuestion_eng() {
        return question_eng;
    }

    public void setQuestion_eng(String question_eng) {
        this.question_eng = question_eng;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<OptionsBean> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionsBean> options) {
        this.options = options;
    }
}
