package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText txtSongTitle;
    EditText txtSongAuthor;
    EditText txtSongLength;
    Spinner spnGenere;
    Button btnAddSong;
    Button btnShowPlaylist;
    String[] genres = {"Seleziona un Genere","Pop", "Indie", "Rap"};
    ArrayAdapter<String> adapterGenres; // fa da intermediario tra oggetto spinner array statico genres
    SongManager songManager = new SongManager(); // Riferimento a SongManager.java

    private void componentInitialization()
    {
        txtSongTitle = findViewById(R.id.txtSongTitle);
        txtSongAuthor = findViewById(R.id.txtSongAuthor);
        txtSongLength = findViewById(R.id.txtSongLength);
        spnGenere = findViewById(R.id.spnGenere);
        btnAddSong = findViewById(R.id.btnAddSong);
        btnShowPlaylist = findViewById(R.id.btnShowPlaylist);
        adapterGenres = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genres);
        spnGenere.setAdapter(adapterGenres); // collegamento fatto ADAPTER-ARRAY
    }

    private void listenersInitialization()
    {
        btnAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fill
            }
        });

        btnShowPlaylist.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fill
            }
        }));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chiamate di funzioni
        componentInitialization();
        listenersInitialization();





    }
}