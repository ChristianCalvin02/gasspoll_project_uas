package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.databinding.FragmentLoginBinding
import com.example.projectuts_ubayalibrary_160420034.model.User
import com.example.projectuts_ubayalibrary_160420034.viewmodel.ListViewModel
import com.example.projectuts_ubayalibrary_160420034.viewmodel.userViewModel
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment(), LoginListener{
    private lateinit var viewModel:userViewModel
    private lateinit var databinding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return databinding.root
        //return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(userViewModel::class.java)

        val btnRegis = view.findViewById<Button>(R.id.btnRegister)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnRegis.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(view).navigate(action)
        }

        //val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
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

    override fun onButtonToRegisterClick(v: View) {
        TODO("Not yet implemented")
        //val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        //Navigation.findNavController(v).navigate(action)
        //Toast.makeText(context, "r", Toast.LENGTH_SHORT).show()
    }

    override fun onButtonSubmit(v: View, user: User) {
        TODO("Not yet implemented")
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