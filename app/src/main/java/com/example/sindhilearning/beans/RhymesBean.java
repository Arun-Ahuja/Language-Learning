package com.example.sindhilearning.beans;

import android.graphics.drawable.Drawable;

import java.io.File;

/**
 * Created by aliraza on 05/09/2019.
 */

public class RhymesBean {
    private int id;
    private String name_eng;
    private String name_sindhi;
    private int image;
    private int rhyme;
    private int rhyme_mp3;
    private String singer;
    private String music;
    private String writer;


    public RhymesBean(int id, String name_eng, String name_sindhi, int image, int rhyme, int rhyme_mp3, String singer, String music, String writer) {
        this.id = id;
        this.name_eng = name_eng;
        this.name_sindhi = name_sindhi;
        this.image = image;
        this.rhyme = rhyme;
        this.rhyme_mp3 = rhyme_mp3;
        this.singer = singer;
        this.music = music;
        this.writer = writer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public String getName_sindhi() {
        return name_sindhi;
    }

    public void setName_sindhi(String name_sindhi) {
        this.name_sindhi = name_sindhi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRhyme() {
        return rhyme;
    }

    public void setRhyme(int rhyme) {
        this.rhyme = rhyme;
    }

    public int getRhyme_mp3() {
        return rhyme_mp3;
    }

    public void setRhyme_mp3(int rhyme_mp3) {
        this.rhyme_mp3 = rhyme_mp3;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
