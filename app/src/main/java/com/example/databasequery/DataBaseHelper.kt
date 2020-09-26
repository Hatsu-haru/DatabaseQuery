package com.example.databasequery

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataBaseHelper (val context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name,null, version){

    private val createToolsBase = "create table Tools (" +
            " id integer primary key autoincrement," +
            "name text," +
            "author text," +
            "analysis_type text," +
            "download_address text," +
            "introduction text)"

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(createToolsBase)
        }
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO Auto-generate database
        Toast.makeText(context, "Update succeeded", Toast.LENGTH_SHORT).show()
    }

}