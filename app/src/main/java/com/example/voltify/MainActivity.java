package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Dichiarazioni
    private EditText txtSongTitle;
    private EditText txtSongAuthor;
    private EditText txtSongLength;
    private  Spinner spnGenere;
    private Button btnAddSong;
    private Button btnShowPlaylist;
    private final String GENREPLACEHOLDER = "Seleziona un Genere";
    private String[] genres = {GENREPLACEHOLDER, "Pop", "Indie", "Rap"};
    private ArrayAdapter<String> adapterGenres; // fa da intermediario tra oggetto spinner array statico genres
    private SongManager songManager = new SongManager(); // Riferimento a SongManager.java
    private Intent intentPlaylist;

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

        intentPlaylist = new Intent(getApplicationContext(), PlaylistActivity.class);
    }

    private void listenersInitialization()
    {
        btnAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String songTitle = txtSongTitle.getText().toString();
                String songAuthor = txtSongAuthor.getText().toString();
                String songLength = txtSongLength.getText().toString();
                // get text + tostring;
                String songGenre = spnGenere.getSelectedItem().toString();
                if(stringValidation(songTitle, songAuthor, songLength, songGenre))
                {
                    // se vero, istanzio un nuovo oggetto SONG
                    Song song = new Song(songTitle, songAuthor, songGenre, songLength);
                    if(songManager.addSong(song)){
                        Toast.makeText(getApplicationContext(), "Song added!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    // se falso, invio un toast
                    Toast.makeText(getApplicationContext(),"Fill the fields", Toast.LENGTH_SHORT).show();
                    Log.d(MainActivity.class.getName(), "manca un campo");
                }
            }
        });

        btnShowPlaylist.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentPlaylist.putExtra("songsInfos", songManager.getSongsInfos());
                startActivity(intentPlaylist);
            }
        }));
    }

    public boolean stringValidation(String songTitle, String songAuthor, String songLength, String spnGenre)
    {
        return !(songTitle.isEmpty() || songAuthor.isEmpty() || songLength.isEmpty() || spnGenre.equals(GENREPLACEHOLDER));
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