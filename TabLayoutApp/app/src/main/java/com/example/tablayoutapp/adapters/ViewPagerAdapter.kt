package com.example.tablayoutapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutapp.fragments.BooksFragment
import com.example.tablayoutapp.fragments.GamesFragment
import com.example.tablayoutapp.fragments.MoviesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifeCycle) {

    override fun getItemCount(): Int {
        return 3        // as we know the exact fragments to display that's why i use direct value if more then we will declare a variable
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return GamesFragment()
            1 -> return BooksFragment()
            2 -> return MoviesFragment()
        }
        return GamesFragment()
    }
}