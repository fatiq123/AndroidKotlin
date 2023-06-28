package com.example.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // declare the objects for Fragments
        val fragmentFirst: Fragment = FragmentFirst()
        val fragmentSecond: Fragment = FragmentSecond()


        // declare the buttons
        val btnFirst: Button = findViewById(R.id.btnFirstFragment)
        val btnSecond: Button = findViewById(R.id.btnSecondFragment)


        // make events on buttons
        btnFirst.setOnClickListener {

            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentFirst, fragmentFirst)
                .commit()
        }

        btnSecond.setOnClickListener {

            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            // In oder to check the onPause,onDestroy,onDetach,onStop,onDestroyView and others replace the fragment with first fragment also
            // remember I only do this for checking the Life of Fragment
            fragmentTransaction.replace(R.id.fragmentFirst, fragmentSecond)
                .commit()
        }
    }
}