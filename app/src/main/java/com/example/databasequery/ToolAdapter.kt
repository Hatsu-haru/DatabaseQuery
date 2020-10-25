package com.example.databasequery

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

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