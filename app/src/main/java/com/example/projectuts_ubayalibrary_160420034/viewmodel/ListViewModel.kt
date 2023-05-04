package com.example.projectuts_ubayalibrary_160420034.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application):AndroidViewModel(application) {
    val libraryLD = MutableLiveData<Library>()
    val libraryLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG ="volleyTag"
    private var queue: RequestQueue? = null

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun refresh(){
        loadingLD.value = true
        libraryLoadErrorLD.value =false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<Library>(){}.type
                val result = Gson().fromJson<Library>(it, Library::class.java)
                libraryLD.value = result as Library
                loadingLD.value = false
                Log.d("showvolley", it)
            },
            {
                libraryLoadErrorLD.value = true
                loadingLD.value = false
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}