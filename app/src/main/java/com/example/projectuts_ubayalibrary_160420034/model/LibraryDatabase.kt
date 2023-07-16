package com.example.projectuts_ubayalibrary_160420034.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration

@Database(entities = arrayOf(Library::class), version = 1)
abstract class LibraryDatabase:RoomDatabase(){
    abstract fun libraryDao():LibraryDao

    companion object {
        @Volatile
        private var instance: LibraryDatabase? = null
        private val LOCK = Any()

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,LibraryDatabase::class.java, "newlibrarydb"
            )
                .addMigrations()
                .build()

        operator fun invoke(context: Context){
            if(instance!=null){
                synchronized(LOCK){
                    instance ?: buildDatabase(context).also {
                        instance =it
                    }
                }
            }
        }
    }
}