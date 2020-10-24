package com.example.databasequery

import android.app.DownloadManager
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener{
            val intent = Intent(this,ToolsQuery::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val dbHelper = DataBaseHelper(this, "ToolsList.db", 1)
            val db = dbHelper.writableDatabase
        }
        button3.setOnClickListener{
            val intent = Intent(this,ToolsListActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener{
            val intent = Intent(this,AboutOutTeam::class.java)
            startActivity(intent)
        }
    }
}