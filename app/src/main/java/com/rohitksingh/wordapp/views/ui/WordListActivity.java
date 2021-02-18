package com.rohitksingh.wordapp.views.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.callbacks.ListItemClickListener;
import com.rohitksingh.wordapp.models.Word;
import com.rohitksingh.wordapp.views.adapters.WordListAdapter;
import com.rohitksingh.wordapp.viewmodels.WordListViewModel;

import java.util.List;

public class WordListActivity extends AppCompatActivity implements View.OnClickListener, ListItemClickListener {

    public static final String NEW_ADDED_WORD = "WordListActivity.NewAddedWord";

    private RecyclerView wordRecyclerView;
    private WordListAdapter wordListAdapter;
    private FloatingActionButton addWord;
    private WordListViewModel wordViewModel;

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
        wordViewModel = new WordListViewModel(getApplication());
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

    @Override
    public void onClick(View view) {
        openDetailActivity();
    }

    @Override
    public void itemClicked(int position, Word word) {
        deleteItem(position, word);
    }

    private void openDetailActivity(){
        startActivityForResult(new Intent(this, WordDetailActivity.class), 2002);
    }

    private void deleteItem(int position, Word word){
        wordViewModel.deleteWord(word);
    }
}