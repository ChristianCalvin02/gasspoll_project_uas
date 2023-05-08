package com.example.projectuts_ubayalibrary_160420034.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectuts_ubayalibrary_160420034.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class userViewModel(application: Application):AndroidViewModel(application) {
    val userLD = MutableLiveData<User>()
    val userLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG ="volleyTag"
    private var queue: RequestQueue? = null

    fun show(id: String){
        loadingLD.value = true
        userLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://project333401.000webhostapp.com/anmp_project/ubayaLibraryUser.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<User>(){}.type
                val result = Gson().fromJson<User>(it, sType)
                userLD.value = result as User
                loadingLD.value = false
                Log.d("showvolley", it)
            },
            {
                userLoadErrorLD.value = true
                loadingLD.value = false
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}