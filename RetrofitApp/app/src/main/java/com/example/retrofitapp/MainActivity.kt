package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitapp.databinding.ActivityMainBinding
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> =
            liveData {
                //val response = retrofitService.getAlbums()

                val response2 = retrofitService.getSpecificAlbum(6)
                emit(response2)
            }

        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()

            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumItem = albumsList.next()
//                    Log.i("Tag", albumItem.title)

                    val result = " Album title: ${albumItem.title} \n"

                    binding.tvView.append(result)
                }
            }
        })

    }
}