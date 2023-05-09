package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.viewmodel.ListViewModel
import com.example.projectuts_ubayalibrary_160420034.viewmodel.userViewModel
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    //private lateinit var viewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel = ViewModelProvider(this).get(userViewModel::class.java)

        val btnRegis = view.findViewById<Button>(R.id.btnRegister)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnRegis.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }

        var txtUsername = view.findViewById<EditText>(R.id.txtUsername)
        var txtPassword = view.findViewById<EditText>(R.id.txtPassword)
        val username = txtUsername?.text.toString()
        val password = txtPassword?.text.toString()
        btnSubmit.setOnClickListener {
            if(txtUsername.text.toString() == "guest" &&  txtPassword.text.toString() == "guest"){
                val action = LoginFragmentDirections.actionLoginFragmentToItemHome()
                Navigation.findNavController(it).navigate(action)
            }
            //viewModel.show(id)
        }
    }
    //Note Error tidak diketahui
/*
    fun observeViewModel(){
        var txtUsername = view?.findViewById<EditText>(R.id.txtUsername)
        var txtPassword = view?.findViewById<EditText>(R.id.txtPassword)
        val id = txtUsername?.text.toString()
        val password = txtPassword?.text.toString()
        viewModel.userLD.observe(viewLifecycleOwner, Observer{
            /*
            if(id == it.id){
                Toast.makeText(context, "data found", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Error !!! data not found", Toast.LENGTH_SHORT).show()
            }*/
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
        })
    }*/
}