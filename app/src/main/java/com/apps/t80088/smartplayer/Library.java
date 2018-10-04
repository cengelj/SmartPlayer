package com.apps.t80088.smartplayer;

import android.media.MediaMetadataRetriever;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

// This class is a singleton as there shouldn't be more than one library
// and it should be accessible from anywhere.
public class Library  implements Serializable {
    private static class helper{private static final Library library = new Library();}
    private static final long serialversionUID = 5361726168L;
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlists;
    private ArrayList<Artist> artists;
    private ArrayList<Album> albums;

    private Library(){
        // Will only be called if it does not exist yet
        // Setup ArrayLists...
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        artists = new ArrayList<>();
        albums = new ArrayList<>();
    }

    public static Library getLibrary() {return helper.library;}
    public void addSong(Song s){songs.add(s);}
    public void addPlaylist(String name){playlists.add(new Playlist(name));}
    public void addArtist(Artist a){artists.add(a);}
    public void addAlbum(Album a){albums.add(a);}

    public ArrayList<Song> getSongs(){return songs;}
    public ArrayList<Playlist> getPlaylists(){return playlists;}
    public ArrayList<Artist> getArtists(){return artists;}
    public ArrayList<Album> getAlbums(){return albums;}
    protected Object readResolve() {return getLibrary();}

    // Recursive functions yay
    public void setUpLibrary(File dir){
        // Called by the main activity at startup if it is the first time being setup,
        // or the user manually resets the library, or changes the library location.
        // Don't touch the playlists here!
        for(File f:dir.listFiles()){
            if(f.isDirectory())
                setUpLibrary(f);
            else {
                if(!f.toString().endsWith(".mp3")
                        && !f.toString().endsWith(".flac")
                        && !f.toString().endsWith(".wma")
                        && !f.toString().endsWith(".m4a"))
                    continue;

                MediaMetadataRetriever m = new MediaMetadataRetriever();
                m.setDataSource(f.toString());

                String name = m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                String artist = m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                String album = m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
                String lengthString = m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                int pos = Integer.parseInt(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER));
                double lengthTotal = Double.parseDouble(lengthString);
                double lengthSeconds = (lengthTotal%60000/1000)+(lengthTotal/60000)*60;
                System.out.println(name + ":" + artist + ":" + album);
                System.out.println(lengthSeconds);

                Song s = new Song(f.toPath().toString(), name, artist, album, lengthSeconds, pos);
                songs.add(s);
                boolean found = false;
                for(Artist a:artists){
                    if(a.getName().equals(artist)){
                        a.addSong(s);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    Artist a = new Artist(artist);
                    a.addSong(s);
                    artists.add(a);
                }
                found = false;
                for(Album a:albums){
                    if(a.getName().equals(album) && a.getArtist().equals(artist)){
                        a.addSong(s);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    Album a = new Album(album, artist);
                    a.addSong(s);
                    albums.add(a);
                }
            }
        }
    }
    // For Debugging
    public void printLibrary(){
        for(Song s:songs)
            System.out.println(s);
    }
}
