package com.example.projectuts_ubayalibrary_160420034.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Library(
    val id:String?,
    val book_name:String?,
    val description:String?,
    val author:String?,
    val rating:Double,
    val image_url:String?
)

@Entity
data class User(
    /*@ColumnInfo(name="id")
    val id:String?,*/
    @ColumnInfo(name="user_name")
    val user_name:String?,
    @ColumnInfo(name="password")
    val password: String?,
    @ColumnInfo(name="name")
    val name: String?,
    @ColumnInfo(name="image_url")
    val image_url: String,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

}