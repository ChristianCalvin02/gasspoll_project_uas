package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.projectuts_ubayalibrary_160420034.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtNameID = view.findViewById<EditText>(R.id.txNameID)
        val txtName = view.findViewById<EditText>(R.id.txtNames)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.isShown
        var name = "guest"
        txtNameID.text
        txtName.text
    }
}