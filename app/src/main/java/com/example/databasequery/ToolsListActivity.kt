package com.example.databasequery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tools_list.*
import kotlinx.android.synthetic.main.activity_tools_query.*
import kotlinx.android.synthetic.main.activity_tools_query.datalist
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import kotlin.concurrent.thread

class ToolsListActivity : AppCompatActivity() {

    private val toolList = ArrayList<Tool>()
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_list)
        initData()
        val layoutManager = LinearLayoutManager(this)
        datalist.layoutManager = layoutManager
        val adapter = ToolAdapter(toolList)
        datalist.adapter = adapter
        Toast.makeText(this,toolList[1].name, Toast.LENGTH_LONG).show()
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_list)
        getListData()
        val adapter = ToolAdapter(this, R.layout.tool_search_item, toolList)
        listview.adapter = adapter
    }
    private fun getListData(){
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder().url("http://localhost/test.php").build()
                val response = client.newCall(request).execute()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        repeat(20) {
            toolList.add(Tool(2,"a","DNA"))
            toolList.add(Tool(1, "b", "RNA"))
        }
    }
}