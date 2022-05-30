package com.example.pract12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class GridViewAdapter(context: Context, courseModelArrayList: ArrayList<Int>) :
    ArrayAdapter<Int>(context, 0, courseModelArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.gridview_item, parent, false)
        }
        val image = getItem(position)
        val iv: ImageView = listitemView!!.findViewById(R.id.image)
        iv.setImageResource(image!!)
        return listitemView
    }

}