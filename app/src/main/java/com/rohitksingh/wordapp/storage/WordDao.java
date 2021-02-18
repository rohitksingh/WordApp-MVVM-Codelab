package com.rohitksingh.wordapp.storage;

import com.rohitksingh.wordapp.models.Word;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

//Doa is the place where you write SQL Query
@Dao
public interface WordDao {

    @Insert
    void addWord(Word word);

    @Query("DELETE from word_table")
    void deleteAllWords();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    @Delete
    void deleteItem(Word word);

}
