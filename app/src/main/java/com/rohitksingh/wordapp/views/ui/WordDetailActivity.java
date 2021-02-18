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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WordDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editWord;
    private Button button, addMore, addLess;
    private TextView quantityTextView;
    int quantity = 0;

    ActivityWordDetailBinding binding;

    /***********************************************************************************************
     *                              Lifecycle Methods
     **********************************************************************************************/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();


//        setContentView(R.layout.activity_word_detail);
//        editWord = findViewById(R.id.editWord);
//        quantityTextView = findViewById(R.id.quantity);
//        button = findViewById(R.id.save);
//        addMore = findViewById(R.id.addMore);
//        addLess = findViewById(R.id.addLess);
//        button.setOnClickListener(this);
//        addMore.setOnClickListener(this);
//        addLess.setOnClickListener(this);
    }


    /***********************************************************************************************
     *                              Callback methods
     **********************************************************************************************/
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.save:
                save();
                break;

            case R.id.addMore:
                addMore();
                break;

            case R.id.addLess:
                addLess();
                break;

            default:
                break;

        }
    }

    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_word_detail);
        binding.setLifecycleOwner(this);
    }

    private void save(){
        Word word = new Word(editWord.getEditableText().toString());
        word.setQuantity(quantity);
        Intent result = new Intent();
        result.putExtra(WordListActivity.NEW_ADDED_WORD, word);
        setResult(Activity.RESULT_OK, result);
        finish();
    }

    private void addMore(){
        quantity++;
        quantityTextView.setText(quantity+"");
    }

    private void addLess(){
        quantity--;
        quantityTextView.setText(quantity+"");
    }
}
