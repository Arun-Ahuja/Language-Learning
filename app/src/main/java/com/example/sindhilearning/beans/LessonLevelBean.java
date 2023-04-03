package com.example.sindhilearning.beans;

import java.util.ArrayList;
/**
 * Created by aliraza on 06/30/2019.
 */

public class LessonLevelBean {
    private boolean isCompleted;
    ArrayList<LessionBean> lessionBeans;

    public LessonLevelBean(boolean isCompleted, ArrayList<LessionBean> lessionBeans) {
        this.isCompleted = isCompleted;
        this.lessionBeans = lessionBeans;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public ArrayList<LessionBean> getLessionBeans() {
        return lessionBeans;
    }



}
