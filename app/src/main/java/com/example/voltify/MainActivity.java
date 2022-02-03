package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Dichiarazioni
    EditText txtSongTitle;
    EditText txtSongAuthor;
    EditText txtSongLength;
    Spinner spnGenere;
    Button btnAddSong;
    Button btnShowPlaylist;
    final String GENREPLACEHOLDER = "Seleziona un Genere";
    String[] genres = {GENREPLACEHOLDER, "Pop", "Indie", "Rap"};
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
                }
            }
        });

        btnShowPlaylist.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fill
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