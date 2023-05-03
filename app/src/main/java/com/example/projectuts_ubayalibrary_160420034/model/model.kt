package com.example.projectuts_ubayalibrary_160420034.model

import com.google.gson.annotations.SerializedName

data class Library(
    val id:String?,
    @SerializedName("book_name")
    val name:String?,
    @SerializedName("description")
    val desc:String?,
    @SerializedName("authors")
    val author:String?,
    @SerializedName("image_url")
    val image:String?
)