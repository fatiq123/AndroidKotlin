package com.example.retrofitapp

import com.google.gson.annotations.SerializedName

// 1. Data Class POJO
// use for objects of JSON -> {}
data class AlbumItem(
    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String,
)
