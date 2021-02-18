package com.rohitksingh.wordapp;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> words;

    public WordRepository(Application application){
        WordDataBase wordDataBase = WordDataBase.createInstance(application);
        wordDao = wordDataBase.wordDao();
    }

    public LiveData<List<Word>> getWords(){
        return wordDao.getAllWords();
    }

    public void addWord(Word word){
       new insertAsyncTask(wordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        insertAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... params) {
            wordDao.addWord(params[0]);
            return null;
        }
    }

}
