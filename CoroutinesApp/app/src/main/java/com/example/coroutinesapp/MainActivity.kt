package com.example.coroutinesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    private var counter: Int = 0

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnStartCoroutine.setOnClickListener {
            binding.tvAdd.text = counter++.toString()
        }

        binding.btnStartDownload.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                downloadBigFileFromNet()
//            }
            GlobalScope.launch {    // it is a CoroutineScope but without context
                downloadBigFileFromNet()
            }

        }

        binding.btnNextActivity.setOnClickListener {
            val i = Intent(this,CoroutinesActivity::class.java)
            startActivity(i)
        }

    }

    private fun downloadBigFileFromNet() {
        for (i in 1..100000) {
            Log.i("Tag", "Downloading $i in ${Thread.currentThread().name}")

        }
    }
}