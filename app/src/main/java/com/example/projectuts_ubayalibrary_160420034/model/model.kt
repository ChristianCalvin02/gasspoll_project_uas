package com.example.projectuts_ubayalibrary_160420034.model

import com.google.gson.annotations.SerializedName

data class Library(
    val id:String?,
    val book_name:String?,
    val description:String?,
    val author:String?,
    val rating:Double,
    val image_url:String?
)

data class User(
    val id:String?,
    val user_name:String?,
    val password: String?,
    val name: String?
)