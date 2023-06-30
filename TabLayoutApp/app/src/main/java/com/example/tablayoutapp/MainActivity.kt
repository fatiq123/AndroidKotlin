package com.example.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayoutapp.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val tabsArray = arrayOf("Games", "Books", "Movies")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)


        val adapter = ViewPagerAdapter(
            supportFragmentManager,
            lifecycle
        )

        viewPager.adapter = adapter


        // connecting the viewpager with tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            tab.text = tabsArray[position]

        }.attach()

    }
}