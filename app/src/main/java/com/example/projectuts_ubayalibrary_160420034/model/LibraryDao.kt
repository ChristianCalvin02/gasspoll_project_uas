package com.example.projectuts_ubayalibrary_160420034.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LibraryDao {
    @Query("SELECT * FROM library WHERE id=:id")
    fun selectLibrary(id:Int):Library

    @Query("SELECT * FROM library")
    fun selectAllLibrary():List<Library>

    /*@Query("UPDATE user SET user_name=:user_name, password=:password")
    fun update(user_name:String, password=:String)*/
}