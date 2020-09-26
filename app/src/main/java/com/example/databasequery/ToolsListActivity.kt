package com.example.databasequery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tools_query.*

class ToolsListActivity : AppCompatActivity() {
    private val ToolList = ArrayList<Tool>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools_list)
        initData()
        val layoutManager = LinearLayoutManager(this)
        val adapter = ToolAdapter(ToolList)
        Toast.makeText(this,ToolList[1].name, Toast.LENGTH_LONG).show()
        datalist.layoutManager = layoutManager
        datalist.adapter = adapter
    }

    private fun initData(){
        repeat(20) {
            ToolList.add(Tool(1, "a", "DNA"))
        }
    }
}