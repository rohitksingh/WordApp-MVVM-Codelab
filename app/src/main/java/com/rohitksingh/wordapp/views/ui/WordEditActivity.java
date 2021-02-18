package com.rohitksingh.wordapp.views.ui;

import android.os.Bundle;

import com.rohitksingh.wordapp.models.Word;

import androidx.appcompat.app.AppCompatActivity;

public class WordEditActivity extends AppCompatActivity {

    public static final String EDIT_WORD = "WordEditActivity.EDIT_WORD";
    private Word word;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        word = (Word) getIntent().getSerializableExtra(EDIT_WORD);
    }
}
