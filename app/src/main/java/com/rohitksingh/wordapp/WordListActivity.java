package com.rohitksingh.wordapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WordListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView wordRecyclerView;
    private WordListAdapter wordListAdapter;
    private FloatingActionButton addWord;
    public static final String NEW_ADDED_WORD = "WordListActivity.NewAddedWord";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        addWord = findViewById(R.id.addWord);
        addWord.setOnClickListener(this);
        wordRecyclerView = findViewById(R.id.wordRecyclerView);
        wordListAdapter = new WordListAdapter(this);
        wordRecyclerView.setAdapter(wordListAdapter);
        wordRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            Word word = (Word) data.getSerializableExtra(NEW_ADDED_WORD);
            Toast.makeText(this, word.getWord(), Toast.LENGTH_SHORT).show();
        }
    }

    private void openDetailActivity(){
        startActivityForResult(new Intent(this, WordDetailActivity.class), 2002);
    }

    @Override
    public void onClick(View view) {
        openDetailActivity();
    }
}