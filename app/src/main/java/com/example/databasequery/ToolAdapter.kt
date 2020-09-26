package com.example.databasequery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToolAdapter(val ToolList: List<Tool>) :RecyclerView.Adapter<ToolAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name)
        val download: TextView = view.findViewById(R.id.download)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_tools_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tool = ToolList[position]
        holder.name.text = tool.name
        holder.download.text = tool.download
    }

    override fun getItemCount() =  ToolList.size
}