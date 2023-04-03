package com.example.sindhilearning.beans;

/**
 * Created by aliraza on 05/20/2019.
 */

public class WordsBean {

    private String broken_sindhi;
    private String sindhi;
    private String english;
    private int color;
    private int image;
    private int sound;

    public WordsBean(String broken_sindhi, String sindhi, String english, int color, int image, int sound) {
        this.broken_sindhi = broken_sindhi;
        this.sindhi = sindhi;
        this.english = english;
        this.color = color;
        this.image = image;
        this.sound=sound;
    }

    public String getBroken_sindhi() {
        return broken_sindhi;
    }

    public void setBroken_sindhi(String broken_sindhi) {
        this.broken_sindhi = broken_sindhi;
    }

    public String getSindhi() {
        return sindhi;
    }

    public void setSindhi(String sindhi) {
        this.sindhi = sindhi;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
