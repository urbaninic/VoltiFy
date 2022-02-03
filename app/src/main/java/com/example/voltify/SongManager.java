package com.example.voltify;

import android.widget.Toast;

import java.util.ArrayList;

public class SongManager {
    // Tipo         - NomeArray = new Tipo;
    ArrayList<Song> songs;

    public SongManager()
    {
        songs = new ArrayList<Song>();
    }

    public boolean addSong(Song song)
    {
        songs.add(song);
        // Segue controllo per verificare la corretta aggiunta all'arraylist
        return ! songs.isEmpty();
    }

desp
}
