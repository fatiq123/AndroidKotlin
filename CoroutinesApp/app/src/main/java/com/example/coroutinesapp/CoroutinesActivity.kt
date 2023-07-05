package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityCorountinesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCorountinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corountines)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_corountines)

        sayHelloFromMainThread()
        sayHelloFromBackgroundThread()


        binding.btnGoBack.setOnClickListener {
            finish()
        }

    }

    private fun sayHelloFromMainThread() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.tvMain.text = "Hello from " + "${Thread.currentThread().name}"
        }
    }

    private fun sayHelloFromBackgroundThread() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.tvBackground.text = "Hello from " + "${Thread.currentThread().name}"
        }

    }


}