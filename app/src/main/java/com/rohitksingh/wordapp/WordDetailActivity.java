package com.rohitksingh.wordapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WordDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editWord;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        editWord = findViewById(R.id.editWord);
        button = findViewById(R.id.save);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Word word = new Word(editWord.getEditableText().toString());
        Intent result = new Intent();
        result.putExtra(WordListActivity.NEW_ADDED_WORD, word);
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
