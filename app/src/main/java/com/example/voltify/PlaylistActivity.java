package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PlaylistActivity extends AppCompatActivity {

    TextView txtSongsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        txtSongsContainer = findViewById(R.id.txtSongsContainer);
        Intent intent = getIntent();
        String songsInfo = intent.getStringExtra("songsInfos");

        txtSongsContainer.setText(songsInfo);
    }
}