package com.apps.t80088.smartplayer;

import java.io.Serializable;
import java.util.ArrayList;

public class Song implements Serializable{
    private String name, artist, album, path;
    private int albumPos, pos;
    private double length;
    private ArrayList<Song> linkedTo;
    private boolean isLinked;

    //Constructors
    //When the panel cannot find one or more of the parameters it will fill it instead with unknown.
    //Later allow for setting of artist and album.
    public Song(String path, String name, double length, int pos){
        this(path, name, "unknown", "unknown", length, pos);
    }
    public Song(String path, String name, String artist, double length, int pos){
        this(path, name, artist, "unknown", length, pos);
    }
    public Song(String path, String name, String artist, String album, double length, int albumPos){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.path = path;
        this.length = length;
        this.albumPos = albumPos;
    }

    //Getters
    public String getName(){return name;}
    public String getArtist(){return artist;}
    public String getAlbum(){return album;}
    public String getPath(){return path;}
    public int getAlbumPos(){return albumPos;}
    public double getTime(){return length;}
    public boolean isLinked(){return isLinked;}

    // Need link method
    /**
     * Will @Return null if called when the arraylist contains only 1 item. Use while(isLinked()) to avoid that.
     **/
    public Song unlink(){
        if(linkedTo.size() > 1){
            if(pos == 0)
                return linkedTo.remove(1);
            else
                return linkedTo.remove(0);
        }
        return null;
    }
    public String toString(){return name + ":" + album + ":" + artist;}

    // For sorting albums
}

