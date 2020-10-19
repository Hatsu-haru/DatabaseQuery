package com.example.databasequery

import android.R.id
import android.app.DownloadManager
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService


class DataBaseHelper(val context: Context, name: String, version: Int) : SQLiteOpenHelper(
    context, name, null, version) {
    private val createSearch = "create table Search (" +
            " id integer primary key autoincrement," +
            "name text," +
            "analysis_type text)"

    private val createInformation = "create table Information (" +
            " name text primary key," +
            "author text," +
            "download_address text," +
            "introduction text)"

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(createSearch)
            db.execSQL(createInformation)
        }
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists Search")
        db.execSQL("drop table if exists Information")
        onCreate(db)
        Toast.makeText(context, "Update succeeded", Toast.LENGTH_SHORT).show()
    }
}