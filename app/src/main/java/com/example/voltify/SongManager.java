package com.example.voltify;

import java.util.ArrayList;

public class SongManager {
    // Tipo         - NomeArray = new Tipo;
    ArrayList<Song> songs;

    public SongManager()
    {
        songs = new ArrayList<Song>();
    }

    public void addSong(Song s)
    {
        songs.add(s);
    }


}
