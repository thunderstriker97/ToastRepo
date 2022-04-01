package com.example.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DBHelper extends SQLiteOpenHelper {
    public static DBHelper mInstance;
    private  Context context;

    public static  DBHelper getInstance(Context context)
    {
        if (mInstance==null){
            mInstance = new DBHelper(context.getApplicationContext());
        }
        return mInstance;

    }


    public DBHelper(@Nullable Context context) {
        super(context, DBManagers.DB_NAME, null, DBManagers.DB_VERSION);

        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db=SQLiteDatabase object, pointing to a newly-created database
        db.execSQL(DBManagers.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBManagers.TABLE_NAME);
        onCreate(db);
    }

    public void saveInDB(String data){
        SQLiteDatabase db= this.getWritableDatabase();


            ContentValues values = new ContentValues();
            values.put(DBManagers.USER_NAME, data);
            db.insert(DBManagers.TABLE_NAME, DBManagers.USER_NAME, values);
    }

     @SuppressLint("Range")
     public String[] getFromDB(){
        Cursor cursor= null;
        String[] string= new String[3];

        SQLiteDatabase db= this.getReadableDatabase();
        String query= "Select * from " +DBManagers.TABLE_NAME;
       cursor= db.rawQuery(query,null);
         System.out.println(""+cursor.getCount());
         if (cursor.moveToFirst()){
             do {
                 string[0]= cursor.getString(cursor.getColumnIndex(DBManagers.USER_NAME));
             }
             while (cursor.moveToNext());





       }
       return string;

    }

}
