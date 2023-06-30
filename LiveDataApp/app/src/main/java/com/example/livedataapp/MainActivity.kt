package com.example.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // declaring the DataBinding
    private lateinit var binding: ActivityMainBinding

    // declaring objects for classes
    private lateinit var viewModel: MainActivityLiveData
    private lateinit var viewModelFactory: MainActivityLiveDataFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // initialize the dataBinding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // initialize the viewModelFactory class
        viewModelFactory = MainActivityLiveDataFactory(100)


        // initialize the viewModel class
        viewModel = ViewModelProvider(this,viewModelFactory)[MainActivityLiveData::class.java]


        // observing for any data change
        viewModel.totalSum.observe(
            this,
            Observer {
                binding.tvShowText.text = it.toString()
            }
        )




        binding.apply {

            btnAdd.setOnClickListener {
//                val enteredNumber: Int = etEnterName.text.toString().toInt()
//                tvShowText.text = enteredNumber.toString()
                viewModel.sumUp(etEnterName.text.toString().toInt())
            }
        }

    }
}