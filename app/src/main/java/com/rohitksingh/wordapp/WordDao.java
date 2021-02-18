package com.rohitksingh.wordapp;

import com.rohitksingh.wordapp.Word;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

//Doa is the place where you write SQL Query
@Dao
public interface WordDao {

    @Insert
    public void addWord(String word);

    @Query("DELETE from word_table")
    public void deleteAllWords();

    @Query("SELECT * from word_table ORDER BY word ASC")
    public LiveData<List<Word>> getAllWords();

}
