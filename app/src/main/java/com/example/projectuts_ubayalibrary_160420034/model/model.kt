package com.example.projectuts_ubayalibrary_160420034.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Library(
    @ColumnInfo(name="book_name")
    var book_name:String?,
    @ColumnInfo(name="description")
    var description:String?,
    @ColumnInfo(name="author")
    var author:String?,
    @ColumnInfo(name="rating")
    var rating:Double,
    @ColumnInfo(name="image_url")
    var image_url:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

@Entity
data class User(
    /*@ColumnInfo(name="id")
    val id:String?,*/
    @ColumnInfo(name="user_name")
    var user_name:String?,
    @ColumnInfo(name="password")
    var password: String?,
    @ColumnInfo(name="name")
    var name: String?,
    @ColumnInfo(name="image_url")
    var image_url: String?,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

}