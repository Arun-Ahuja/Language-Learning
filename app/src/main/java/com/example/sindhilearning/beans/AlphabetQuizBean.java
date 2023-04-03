package com.example.sindhilearning.beans;



/**
 * Created by aliraza on 05/22/2019.
 */

public class AlphabetQuizBean {
    private int id;
    private String sindhi;
    private String english;
    private int image;
    private String[] options;
    private String answer;
    private boolean isCompleted;


    public AlphabetQuizBean(int id, String sindhi, String english, int image, String[] options, String answer, boolean isCompleted) {
        this.id = id;
        this.sindhi = sindhi;
        this.english = english;
        this.image = image;
        this.options = options;
        this.answer = answer;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getSindhi() {
        return sindhi;
    }

    public String getEnglish() {
        return english;
    }

    public int getImage() {
        return image;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
