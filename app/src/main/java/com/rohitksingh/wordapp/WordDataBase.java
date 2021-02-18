package com.rohitksingh.wordapp;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//This is the database class
//It is singleton
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "word_database";

    public static WordDataBase INSTANCE;

    public abstract WordDao createWordDao();

    public static WordDataBase getInstance(final Context context){
        if(INSTANCE==null){
            INSTANCE = createInstance(context);
        }

        return INSTANCE;
    }

    public static WordDataBase createInstance(Context context){
        return Room.databaseBuilder(context.getApplicationContext(),
                WordDataBase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

}
