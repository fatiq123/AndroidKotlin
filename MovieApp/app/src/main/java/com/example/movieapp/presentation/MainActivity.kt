package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: ViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)   // remember i have done this

        (application as Injector).createMovieSubComponent().inject(this)    // new thing

        movieViewModel = ViewModelProvider(this, factory = factory)[ViewModel::class.java]  // I have also done this in previous projects


    }
}