package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.projectuts_ubayalibrary_160420034.R

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegister = view.findViewById<Button>(R.id.btnRegis)
        var username = view.findViewById<EditText>(R.id.txtRegisUser)
        var password = view.findViewById<EditText>(R.id.txtRegisPassword)
        btnRegister.setOnClickListener {
            if(username.text.toString() != "" && password.text.toString() != ""){
                val action = RegisterFragmentDirections.actionRegisterFragmentToItemHome()
                Navigation.findNavController(it).navigate(action)
                Toast.makeText(context, "Registration Success", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Registrasi Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}