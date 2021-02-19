package com.rohitksingh.wordapp.views.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.databinding.ActivityWordDetailBinding;
import com.rohitksingh.wordapp.models.Word;
import com.rohitksingh.wordapp.viewmodels.WordDetailViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class WordDetailActivity extends AppCompatActivity{

    private ActivityWordDetailBinding binding;
    private WordDetailViewModel viewModel;

    /***********************************************************************************************
     *                              Lifecycle Methods
     **********************************************************************************************/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        getSavedData();
        observeViewModel();
    }


    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_word_detail);
        viewModel = ViewModelProviders.of(this).get(WordDetailViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    private void save(){
        Intent result = new Intent();
        Word word = viewModel.wordLiveData.getValue();
        result.putExtra(WordListActivity.NEW_ADDED_WORD, word);
        setResult(Activity.RESULT_OK, result);
        finish();
    }

    private void getSavedData(){
        if(getIntent().getSerializableExtra(WordListActivity.NEW_ADDED_WORD)!=null){
            Word savedWord = (Word) getIntent().getSerializableExtra(WordListActivity.NEW_ADDED_WORD);
            viewModel.wordLiveData.setValue(savedWord);
        }
    }

    private void observeViewModel(){
        viewModel.signal.observe(this, signalValue -> {
            if(signalValue==WordDetailViewModel.SAVE_BUTTON_CLICKED){
                save();
            }
        });
    }


}
