package com.example.sindhilearning.beans;

/**
 * Created by aliraza on 05/18/2019.
 */

public class ConsonentBean {

    private int id;
    private String consonent;
    private int sound;
    private int color;

    public ConsonentBean(int id, String consonent, int sound, int color) {
        this.id = id;
        this.consonent = consonent;
        this.sound = sound;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsonent() {
        return consonent;
    }

    public void setConsonent(String consonent) {
        this.consonent = consonent;
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
