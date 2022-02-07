package com.example.voltify;

import android.widget.Toast;

import java.util.ArrayList;

public class SongManager {
    // Tipo         - NomeArray = new Tipo;
    private ArrayList<Song> songs;

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

    public String getSongsInfos()
    {
        StringBuilder sb = new StringBuilder();
        for (Song song : songs)
        // per ogni elemento song di songs:
        {
            sb.append(song.toString());
            sb.append("\n");
        }
        //Accorpamento in uunica stringa in stringbuilder
        return sb.toString();
    }
}
