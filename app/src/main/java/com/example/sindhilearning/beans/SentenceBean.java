package com.example.sindhilearning.beans;

/**
 * Created by aliraza on 05/14/2019.
 */

public class SentenceBean {

    private int id;
    private String sentence_sindhi;
    private String sentence_uru;
    private String sentence_english;
    private int sound;
    private int color;

    public SentenceBean(int id, String sentence_sindhi, String sentence_uru, String sentence_english, int sound, int color) {
        this.id = id;
        this.sentence_sindhi = sentence_sindhi;
        this.sentence_uru = sentence_uru;
        this.sentence_english = sentence_english;
        this.sound = sound;
        this.color=color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getSentence_sindhi() {
        return sentence_sindhi;
    }

    public String getSentence_uru() {
        return sentence_uru;
    }

    public String getSentence_english() {
        return sentence_english;
    }

    public int getSound() {
        return sound;
    }
}
