package com.example.viewpagerapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerapp.fragments.FragmentOne
import com.example.viewpagerapp.fragments.FragmentThree
import com.example.viewpagerapp.fragments.FragmentTwo
import com.example.viewpagerapp.MainActivity

class MyAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    private val fragmentSize = 3

    override fun getItemCount(): Int {
        return this.fragmentSize
    }

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> {
                return FragmentOne()
            }

            1 -> {
                return FragmentTwo()
            }

            2 -> {
                return FragmentThree()
            }
        }
        return FragmentOne()        // by default the fragment will be FragmentOne()
    }
}