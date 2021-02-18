package com.rohitksingh.wordapp.models;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    public String word;

    @ColumnInfo(name = "quantity")
    public int quantity;

    public Word(@NonNull String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
