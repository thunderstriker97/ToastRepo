package com.example.database;

public class DBManagers {
    //database schema
    public static final String DB_NAME= "MY_DB";

    //table name
    public static final String TABLE_NAME="login";

    // Table columns
    public static final String ID = "id";
    public static final String USER_NAME = "username";


    public static final int DB_VERSION=2;
    public static final String CREATE_TABLE ="CREATE TABLE " + TABLE_NAME + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
             + USER_NAME + " TEXT)";
}
