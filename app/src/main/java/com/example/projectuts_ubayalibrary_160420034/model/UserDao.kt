package com.example.projectuts_ubayalibrary_160420034.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: User)
/*
    @Query("SELECT user WHERE user_name=:user_name && password=:password FROM user")
    fun selectUser(user_name:String, password:String)

    @Query("SELECT * FROM user WHERE user_name LIKE=:user_name")
    suspend fun checkUsername(user_name: String)*/
}