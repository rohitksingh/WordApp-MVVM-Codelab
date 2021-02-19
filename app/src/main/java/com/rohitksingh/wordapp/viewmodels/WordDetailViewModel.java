package com.rohitksingh.wordapp.viewmodels;

import android.app.Application;
import android.util.Log;

import com.rohitksingh.wordapp.models.Word;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class WordDetailViewModel extends AndroidViewModel {

    private static final String TAG = "WordDetailViewModel";
    public MutableLiveData<Word> wordLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> signal = new MutableLiveData();

    public static final int SAVE_BUTTON_CLICKED = 1000;
    
    public WordDetailViewModel(@NonNull Application application) {
        super(application);
        Word word = new Word();
        wordLiveData.setValue(word);
    }

    public void increaseQuantity(){
        Word word = wordLiveData.getValue();
        word.setQuantity(++word.quantity);
        wordLiveData.postValue(word);
    }

    public void decreaseQuantity(){
        Word word = wordLiveData.getValue();
        word.setQuantity(--word.quantity);
        wordLiveData.postValue(word);
    }

    public void saveItem(){
        signal.postValue(SAVE_BUTTON_CLICKED);
    }

}
