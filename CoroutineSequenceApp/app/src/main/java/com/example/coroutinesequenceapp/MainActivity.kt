package com.example.coroutinesequenceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("Tag", "The App is started")


        // to run parallel functions using coroutines
        CoroutineScope(Dispatchers.IO).launch {
            val one = async {
                doSomeThing1()
            }
            val two = async {
                doSomeThing2()
            }

            val result = one.await() + two.await()
            Log.v("Tag", "The result is: $result")

        }

    }


    private suspend fun doSomeThing1() : Int{
        delay(10000)
        Log.v("Tag", "Fun1 is done")
        return 11
    }

    private suspend fun doSomeThing2() : Int{
        delay(5000)
        Log.v("Tag", "Fun2 is done")
        return 8
    }


}