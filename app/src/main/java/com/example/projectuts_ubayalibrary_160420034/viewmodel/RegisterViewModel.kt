package com.example.projectuts_ubayalibrary_160420034.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.projectuts_ubayalibrary_160420034.model.User
import com.example.projectuts_ubayalibrary_160420034.util.buildDB2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RegisterViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    val userLD = MutableLiveData<User>()
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun addUser(user: User){
        launch {
            val db = buildDB2(getApplication())
            db.userDao().insertAll(user)
        }
    }
}