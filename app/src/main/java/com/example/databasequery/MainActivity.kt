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
            val values1 = ContentValues().apply {
                put("name", "BWA")
                put("analysis_type", "RNA")
            }
            db.insert("Search", null, values1)
            val values2 = ContentValues().apply {
                put("name", "BWA")
                put("analysis_type", "DNA")
            }
            db.insert("Search", null, values2)
            val values3 = ContentValues().apply {
                put("name", "STAR")
                put("analysis_type", "RNA")
            }
            db.insert("Search", null, values3)
         //   val version = downloadDataBase()
         //   val dbHelper = DataBaseHelper(this, "ToolsList.db", version)
         //   dbHelper.writableDatabase
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

    private fun downloadDataBase(): Int {
        val dManager: DownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        val request = DownloadManager.Request(Uri.parse("https://raw.githubusercontent.com/Hatsu-haru/Temp/main/version2.db"))
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED )
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
        request.setDestinationInExternalFilesDir(this, "/data/data/com.example.databasequery/databases/","test.db")
        dManager.enqueue(request)
        return 2
    }
}