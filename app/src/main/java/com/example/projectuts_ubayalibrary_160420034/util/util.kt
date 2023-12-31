package com.example.projectuts_ubayalibrary_160420034.util

import android.app.NotificationChannel
import android.content.Context
import android.media.Rating
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.model.LibraryDatabase
import com.example.projectuts_ubayalibrary_160420034.model.UserDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

val DB_NAME = "newlibrarydb"
val DB_NAME2 = "newuserdb"

fun buildDB(context: Context):LibraryDatabase{
    val db = Room.databaseBuilder(context, LibraryDatabase::class.java, DB_NAME)
        .addMigrations()
        .build()
    return db
}

fun buildDB2(context: Context):UserDatabase{
    val db = Room.databaseBuilder(context, UserDatabase::class.java, DB_NAME2)
        .addMigrations()
        .build()
    return db
}

fun createNotifChannel(context: Context, importance: Int, showBagde: Boolean, name: String, desc:String){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val channelID = "${context.packageName}-$name"
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc
        channel.setShowBadge(showBagde)
    }
}

fun ImageView.loadImage(url:String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this, object:Callback{
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
            }
        })
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoUrl(view: ImageView, url: String?, progressBar: ProgressBar){
    view.loadImage(url, progressBar)
}
