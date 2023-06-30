package com.example.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerapp.adapters.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)


        adapter = MyAdapter(this)
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        viewPager.adapter = adapter     // this line is important to connect the adapters


        // viewPager properties
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f)
        viewPager.endFakeDrag()
    }
}