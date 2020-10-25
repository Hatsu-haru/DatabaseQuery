package com.example.databasequery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_tools_list.*
import okhttp3.OkHttpClient
import okhttp3.Request

class ToolsListActivity : AppCompatActivity() {
    private val toolList = ArrayList<Tool>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_list)
        val client = OkHttpClient()
        val request = Request.Builder().url("http://10.194.114.197/test.php").build()
        val response = client.newCall(request).execute()
        val responseData = response.body?.string()
        if (responseData != null) {
            val first = responseData.indexOf('[')
            val last = responseData.indexOf(']')
            val json = responseData.substring(first, last + 1)
            val gson = Gson()
            val typeOf = object : TypeToken<List<Tool>>() {}.type
            val tooo = gson.fromJson<List<Tool>>(json, typeOf)
            for (i in tooo) {
                toolList.add(i)
            }
        }
        val adapter = ToolAdapter(this, R.layout.tool_search_item, toolList)
        listview.adapter = adapter
    }
}