package com.rohitksingh.wordapp.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.rohitksingh.wordapp.models.Word;
import com.rohitksingh.wordapp.storage.WordDao;
import com.rohitksingh.wordapp.storage.WordDataBase;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private static final String TAG = "WordRepository";
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
        new dbAsyncTask(wordDao, dbAsyncTask.ADD).execute(word);
    }

    public void updateWord(Word word){
        new dbAsyncTask(wordDao, dbAsyncTask.UPDATE).execute(word);
    }

    public void deleteWord(Word word){
        new dbAsyncTask(wordDao, dbAsyncTask.DELETE).execute(word);
    }

    private static class dbAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;
        private int taskType;
        public static final int ADD = 1000;
        public static final int UPDATE = 1001;
        public static final int DELETE = 1002;




        dbAsyncTask(WordDao wordDao, int taskType){
            this.wordDao = wordDao;
            this.taskType = taskType;
        }

        @Override
        protected Void doInBackground(Word... params) {

            Word word = params[0];

            switch (taskType){

                case ADD:
                    wordDao.addWord(word);
                    break;

                case UPDATE:
                    wordDao.updateWord(word);

                case DELETE:
                    wordDao.deleteItem(word);
            }

            return null;
        }
    }

}
