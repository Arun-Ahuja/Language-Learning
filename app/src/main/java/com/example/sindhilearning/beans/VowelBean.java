package com.example.sindhilearning.beans;

/**
 * Created by aliraza on 05/19/2019.
 */

public class VowelBean {
    private int id;
    private String vowel;
    private int sound;
    private int color;

    public VowelBean(int id, String vowel, int sound, int color) {
        this.id = id;
        this.vowel = vowel;
        this.sound = sound;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVowel() {
        return vowel;
    }

    public void setVowel(String vowel) {
        this.vowel = vowel;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
