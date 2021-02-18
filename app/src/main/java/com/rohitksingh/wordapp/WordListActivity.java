package com.rohitksingh.wordapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class WordListActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String NEW_ADDED_WORD = "WordListActivity.NewAddedWord";

    private RecyclerView wordRecyclerView;
    private WordListAdapter wordListAdapter;
    private FloatingActionButton addWord;
    private WordViewModel wordViewModel;

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
        wordViewModel = new WordViewModel(getApplication());
        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                wordListAdapter.setAllWords(words);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            Word word = (Word) data.getSerializableExtra(NEW_ADDED_WORD);
            wordViewModel.addWord(word);
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