package com.apps.t80088.smartplayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Album implements Serializable{
    private ArrayList<Song> list;
    private String name;
    private String artist;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        list = new ArrayList<>();
    }
    public void addSong(Song s){
        list.add(s);
        Collections.sort(list, new SortByAlbumPos());
    }
    public String getName(){return name;}
    public String getArtist(){return artist;}
}
class SortByAlbumPos implements Comparator<Song>{
    public int compare(Song o1, Song o2) {return (o1.getAlbumPos() - o2.getAlbumPos());}
}
