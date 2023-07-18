package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.databinding.FragmentRegisterBinding
import com.example.projectuts_ubayalibrary_160420034.model.User
import com.example.projectuts_ubayalibrary_160420034.viewmodel.RegisterViewModel

class RegisterFragment : Fragment(), RegisterClickListener {
    private lateinit var  viewModel: RegisterViewModel
    private lateinit var databinding:FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return databinding.root
        //return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        databinding.user = User("", "", "", "")
        databinding.savelistener = this
        /*val btnRegister = view.findViewById<Button>(R.id.btnRegis)
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
        }*/
    }

    override fun onButtonRegisterClick(v: View, user: User) {
        viewModel.addUser(user)
        Toast.makeText(v.context, "New User Succesfully Created", Toast.LENGTH_SHORT).show()
    }
}