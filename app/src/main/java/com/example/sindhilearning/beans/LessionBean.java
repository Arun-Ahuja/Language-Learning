package com.example.sindhilearning.beans;

/**
 * Created by aliraza on 05/23/2019.
 */

public class LessionBean {


    private int index;
    private String letter;
    private int image;
    private int sound;
    private String sindhi;
    private String english;
    private boolean isClicked;


    public LessionBean(int index, String letter, int image, int sound, String sindhi, String english, boolean isClicked) {
        this.index = index;
        this.letter = letter;
        this.image = image;
        this.sindhi = sindhi;
        this.english = english;
        this.sound=sound;
        this.isClicked = isClicked;
    }

    public int getIndex() {
        return index;
    }

    public String getLetter() {
        return letter;
    }

    public int getImage() {
        return image;
    }

    public int getSound() {
        return sound;
    }

    public String getSindhi() {
        return sindhi;
    }

    public String getEnglish() {
        return english;
    }

    public boolean isClicked() {
        return isClicked;
    }
}
