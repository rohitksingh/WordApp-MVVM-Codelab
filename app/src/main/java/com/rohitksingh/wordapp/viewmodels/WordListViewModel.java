package com.rohitksingh.wordapp.viewmodels;

import android.app.Application;

import com.rohitksingh.wordapp.models.Word;
import com.rohitksingh.wordapp.repositories.WordRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordListViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;

    public WordListViewModel(Application application){
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

    public void deleteWord(Word word){
        wordRepository.deleteWord(word);
    }

}
