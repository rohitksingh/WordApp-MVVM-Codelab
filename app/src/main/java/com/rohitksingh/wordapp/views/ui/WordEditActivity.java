package com.rohitksingh.wordapp.views.ui;

import android.os.Bundle;

import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.databinding.ActivityWordDetailBinding;
import com.rohitksingh.wordapp.models.Word;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WordEditActivity extends AppCompatActivity {

    public static final String EDIT_WORD = "WordEditActivity.EDIT_WORD";
    private Word word;

    private ActivityWordDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        word = (Word) getIntent().getSerializableExtra(EDIT_WORD);
        initDataBinding();
    }

    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_word_detail);
        binding.setLifecycleOwner(this);
    }
}
