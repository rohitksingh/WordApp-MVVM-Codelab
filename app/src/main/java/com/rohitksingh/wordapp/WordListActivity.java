package com.rohitksingh.wordapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView wordRecyclerView;
    private WordListAdapter wordListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        wordRecyclerView = findViewById(R.id.wordRecyclerView);
        wordListAdapter = new WordListAdapter(this);
        wordRecyclerView.setAdapter(wordListAdapter);
        wordRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}