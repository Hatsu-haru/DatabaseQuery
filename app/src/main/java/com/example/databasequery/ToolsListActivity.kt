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
import org.json.JSONArray
import kotlin.Exception
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
                //val responseData = response.body?.string()
                val responseData = response.body().toString()
                if(responseData != null){
                    parseJSONWithJSONObject(responseData)
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun parseJSONWithJSONObject(jsonData: String){
        try {
            val jsonArray = JSONArray(jsonData)
            for(i in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(i)
                val id = jsonObject.getInt("id")
                val name = jsonObject.getString("name")
                val type = jsonObject.getString("type")
                toolList.add(Tool(id,name,type))
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}