package com.example.sindhilearning.beans;

/**
 * Created by aliraza on 05/15/2019.
 */

public class OptionsBean {

    private int id;
    private String option;

public OptionsBean(int id, String option) {
        this.id = id;
        this.option = option;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
