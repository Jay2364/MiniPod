package com.example.minipod;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirstAlbum extends AppCompatActivity{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_album);

        // Taking all data from MainActivity
        Intent intent = getIntent();

        String[] name = intent.getStringArrayExtra("strings");
        int[] img = intent.getIntArrayExtra("images");
        int[] song = intent.getIntArrayExtra("songs");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirstAlbumAdapter customArrayAdapter = new FirstAlbumAdapter(name,img,song);
        recyclerView.setAdapter(customArrayAdapter);

    }
 }