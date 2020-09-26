package com.example.databasequery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DataBaseHelper(this, "ToolsList.db", 1)
        dbHelper.writableDatabase
        button1.setOnClickListener{
            val intent = Intent(this,ToolsQuery::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val stringUrl = ""
            val version = DownloadDataBase(stringUrl)
            val dbHelper = DataBaseHelper(this, "ToolsList.db", version)
            dbHelper.writableDatabase
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

    private fun DownloadDataBase(stringUrl: String): Int {
        //待编辑
        return 0
    }
}