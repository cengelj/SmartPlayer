package com.apps.t80088.smartplayer;


import java.io.Serializable;
import java.util.ArrayList;
public class Playlist implements Serializable{
    private ArrayList<Song> list;
    private String name;


    public Playlist(String name){
        this.name = name;
        list = new ArrayList<>();
    }
    // Constructor for copying playlists
    public Playlist(Playlist p){
        for(int i = 0;i<p.getPlaylist().size();i++)
            list.add(p.getPlaylist().get(i));
    }

    /**
     * Used for removal of songs from the playist.
     * @return true if the remaining playlist is empty, false otherwise
     */
    public boolean removeSong(String name){
        for(int i = list.size()-1;i>=0;i--)
            if(list.get(i).getName().equals(name))
                list.remove(i);
        if(list.size()==0)
            return true;
        return false;
    }
    public ArrayList<Song> getPlaylist(){
        return list;
    }
    public String getName(){return name;}

    //To-Do: Add export playlist method.
}

