package com.example.viewmodelapp

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.viewmodelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private var counter = 0
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // view model factory
        factory = MainActivityViewModelFactory(100)

        // view model
//        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel = ViewModelProvider(this,factory)[MainActivityViewModel::class.java]      // to start the count from 100


        binding.textView.text = viewModel.getCurrentCount().toString()

        binding.apply {
            btnCount.setOnClickListener {
//                counter++
//                textView.text = counter.toString()
//                viewModel.getUpdatedCount()
                textView.text = viewModel.getUpdatedCount().toString()
            }
        }
    }
}