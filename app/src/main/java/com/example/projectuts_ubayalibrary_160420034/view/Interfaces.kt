package com.example.projectuts_ubayalibrary_160420034.view

import android.view.View
import com.example.projectuts_ubayalibrary_160420034.model.User
import com.example.projectuts_ubayalibrary_160420034.model.UserDao

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}

interface RegisterClickListener{
    fun onButtonRegisterClick(v: View, user: User)
}

interface LoginListener{
    fun onButtonToRegisterClick(v: View)

    fun onButtonSubmit(v: View, user: User)
}