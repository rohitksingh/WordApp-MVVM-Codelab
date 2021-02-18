package com.rohitksingh.wordapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    public String word;

    public Word(@NonNull String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

}
