package com.example.databasequery

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
/*
class ToolAdapter(val ToolList: List<Tool>) :RecyclerView.Adapter<ToolAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name)
        val type: TextView = view.findViewById(R.id.type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tool_search_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tool = ToolList[position]
        holder.name.text = tool.name
        holder.type.text = tool.type
    }

    override fun getItemCount() =  ToolList.size
}
*/

class ToolAdapter (activity: Activity, val resourceId: Int, data: List<Tool>) : ArrayAdapter<Tool>(activity, resourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
        val name: TextView = view.findViewById(R.id.name)
        val type: TextView = view.findViewById(R.id.type)
        val tool = getItem(position)
        if (tool != null) {
            name.text = tool.name
            type.text = tool.type
        }
        return view
    }
}