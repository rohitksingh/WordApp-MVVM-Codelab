package com.rohitksingh.wordapp.views.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.callbacks.ListItemClickListener;
import com.rohitksingh.wordapp.databinding.ActivityWordListBinding;
import com.rohitksingh.wordapp.models.Word;
import com.rohitksingh.wordapp.views.adapters.WordListAdapter;
import com.rohitksingh.wordapp.viewmodels.WordListViewModel;

import java.util.List;

public class WordListActivity extends AppCompatActivity implements ListItemClickListener {

    private static final String TAG = "WordListActivity";
    public static final String NEW_ADDED_WORD = "WordListActivity.NewAddedWord";
    public static final int ADD_MODE = 1;
    public static final int EDIT_MODE = 2;

    private WordListAdapter wordListAdapter;

    private ActivityWordListBinding binding;
    private WordListViewModel wordViewModel;

    /***********************************************************************************************
     *                              Lifecycle Methods
     **********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupRecyclerView();
        observeViewModel();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){

            Word word = (Word) data.getSerializableExtra(NEW_ADDED_WORD);

            if(requestCode==ADD_MODE){
                wordViewModel.addWord(word);
            }else if(requestCode==EDIT_MODE){
                Toast.makeText(this, word.getWord(), Toast.LENGTH_SHORT).show();
                wordViewModel.updateWord(word);
            }


        }
    }

    /***********************************************************************************************
     *                              Callback methods
     **********************************************************************************************/
    @Override
    public void deleteItem(int position, Word word) {
        deleteWord(position, word);
    }

    @Override
    public void editItem(int position, Word word) {
        openEditActivity(word);
    }

    /***********************************************************************************************
     *                              Private helper methods
     **********************************************************************************************/
    private void openDetailActivity(){
        startActivityForResult(new Intent(this, WordDetailActivity.class), ADD_MODE);
    }

    private void openEditActivity(Word word){
        Intent editWordIntent = new Intent(this, WordDetailActivity.class);
        editWordIntent.putExtra(NEW_ADDED_WORD, word);
        startActivityForResult(editWordIntent, EDIT_MODE);
    }

    private void deleteWord(int position, Word word){
        wordViewModel.deleteWord(word);
    }

    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_word_list);
        wordViewModel = ViewModelProviders.of(this).get(WordListViewModel.class);
        binding.setViewModel(wordViewModel);
        binding.setLifecycleOwner(this);
    }

    private void setupRecyclerView(){
        wordListAdapter = new WordListAdapter(this);
        binding.wordRecyclerView.setAdapter(wordListAdapter);
        binding.wordRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void observeViewModel(){
        wordViewModel.getAllWords().observe(this, words -> {
            wordListAdapter.setAllWords(words);
        });

        wordViewModel.actionOpenDetailActivity.observe(this, action -> {openDetailActivity();});
    }
}