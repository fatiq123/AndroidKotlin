package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.model.Movie
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.di.Injector
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: ViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )   // remember i have done this

        (application as Injector).createMovieSubComponent().inject(this)    // new thing

        movieViewModel = ViewModelProvider(
            this,
            factory = factory
        )[ViewModel::class.java]  // I have also done this in previous projects


        initRecyclerView()
    }

    private fun initRecyclerView() {


        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MovieAdapter()

        binding.recyclerView.adapter =
            adapter      // to connect the Adapter with recyclerView adapter

        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(this, Observer {

            if (it != null) {
                adapter.setList(it as List<Movie>)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE

                Toast.makeText(
                    this,
                    "No Data Available",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.drawable.ic_update -> {
                updateMovies()
                true
            } else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.updateMovies()

        responseLiveData.observe(this, Observer {

            if (it != null) {
                adapter.setList(it as List<Movie>)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }
            else {
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
}