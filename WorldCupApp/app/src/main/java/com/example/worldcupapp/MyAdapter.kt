package com.example.worldcupapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MyAdapter(private var activity: Activity, private var items: ArrayList<CountryModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}