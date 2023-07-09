package com.example.movieapp.data

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("id")
    val movieId: Int,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("title")
    val title: String

)
