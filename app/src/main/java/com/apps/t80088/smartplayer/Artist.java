package com.apps.t80088.smartplayer;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {
    private ArrayList<Song> list;
    private String name;

    public Artist(String name){
        this.name = name;
        list = new ArrayList<>();
    }
    public String getName(){return name;}
    public void addSong(Song s){
        list.add(s);
    }
}
