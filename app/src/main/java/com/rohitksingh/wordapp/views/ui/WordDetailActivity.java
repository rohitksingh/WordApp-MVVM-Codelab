package com.rohitksingh.wordapp.views.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.databinding.ActivityWordDetailBinding;
import com.rohitksingh.wordapp.models.Word;
import com.rohitksingh.wordapp.viewmodels.WordDetailViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
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
        viewModel.signal.observe(this, signalValue -> {
            if(signalValue==WordDetailViewModel.SET_RESULT){
                save();
            }
        });
    }


    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_word_detail);
        viewModel = ViewModelProviders.of(this).get(WordDetailViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    private void save(){
        Intent result = new Intent();
        result.putExtra(WordListActivity.NEW_ADDED_WORD, viewModel.wordLiveData.getValue());
        setResult(Activity.RESULT_OK, result);
        finish();
    }

}
