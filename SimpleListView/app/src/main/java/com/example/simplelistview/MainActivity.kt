package com.example.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Adapter View: ListView (is this case)
        val listView: ListView = findViewById(R.id.listView)

        // 2. Data Source: Array of Strings
        val worldCupArray = arrayOf(
            "England", "France", "Argentina", "Germany"
        )

        // 3. Adapter
        val arrayAdapter: ArrayAdapter<*> = ArrayAdapter(
            this,
//            android.R.layout.simple_list_item_1   in case of default list views provided by android studio
            R.layout.custom_list_view,
            R.id.tvCustomListView,      // this is extra parameter we have to provide in case of custom list views
            worldCupArray
        )

        listView.adapter = arrayAdapter
    }
}