package com.example.android.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class PetsOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    public static final String DATABASE_NAME="PETS_db";
    public PetsOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String petSQL = " CREATE TABLE " + Contract.PetEntry.TABLE_NAME + " ( " +
                          Contract.PetEntry.COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT , " +
                          Contract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL , " +
                          Contract.PetEntry.COLUMN_PET_BREED + " TEXT , " +
                          Contract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL , " +
                          Contract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0 ) ";
        sqLiteDatabase.execSQL(petSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
