package com.example.projectuts_ubayalibrary_160420034.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.util.buildDB
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application):AndroidViewModel(application) , CoroutineScope{
    val libraryLD = MutableLiveData<Library>()
    val libraryLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD =MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    /*val TAG ="volleyTag"
    private var queue: RequestQueue? = null*/

    fun show(id: Int){
        loadingLD.value = true
        libraryLoadErrorLD.value = false

        launch {
            val db = buildDB(getApplication())
            libraryLD.postValue(db.libraryDao().selectLibrary(id))
        }

        /*queue = Volley.newRequestQueue(getApplication())
        val url = "https://project333401.000webhostapp.com/anmp_project/ubayaLibrary.php?id=$id"

        val stringRequest = StringRequest(
            com.android.volley.Request.Method.GET, url,
            {
                val sType = object: TypeToken<Library>(){}.type
                val result = Gson().fromJson<Library>(it, sType)
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
        queue?.add(stringRequest)*/
    }


}