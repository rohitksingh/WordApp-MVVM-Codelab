package com.rohitksingh.wordapp;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(Application application){
        super(application);
        wordRepository = new WordRepository(application);
        allWords = wordRepository.getWords();
    }

    public LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    public void addWord(Word word){
        wordRepository.addWord(word);
    }

}
