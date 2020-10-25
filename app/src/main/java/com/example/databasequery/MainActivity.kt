package com.example.databasequery

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        button1.setOnClickListener{
            val intent = Intent(this, ToolsQuery::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
        }
        button3.setOnClickListener{
            val intent = Intent(this, ToolsListActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener{
            val intent = Intent(this, AboutOutTeam::class.java)
            startActivity(intent)
        }
    }
}