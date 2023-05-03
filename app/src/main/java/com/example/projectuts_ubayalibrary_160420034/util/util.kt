package com.example.projectuts_ubayalibrary_160420034.util

import android.app.NotificationChannel
import android.content.Context
import android.os.Build
import android.widget.ImageView
import android.widget.ProgressBar

fun createNotifChannel(context: Context, importance: Int, showBagde: Boolean, name: String, desc:String){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val channelID = "${context.packageName}-$name"
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc
        channel.setShowBadge(showBagde)
    }
}

fun ImageView.loadImage(url:String?, progressBar: ProgressBar){

}