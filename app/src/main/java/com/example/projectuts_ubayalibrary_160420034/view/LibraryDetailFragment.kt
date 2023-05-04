package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class LibraryDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        if(arguments != null){
            val id = "" // update jangan lupa masih ada yang kurang
            viewModel.show(id)
        }
        ObserveViewModels()
    }

    fun ObserveViewModels(){
        val txtId = view?.findViewById<TextView>(R.id.txtIdBook)
        val txtTitle = view?.findViewById<TextView>(R.id.txtBookName)
        val txtAuthor = view?.findViewById<TextView>(R.id.txtAuthor)
        val txtDesc = view?.findViewById<TextView>(R.id.txtDesc)
        val category = view?.findViewById<TextView>(R.id.txtCategory)
        val poster = view?.findViewById<ImageView>(R.id.imageView)

        viewModel.libraryLD.observe(viewLifecycleOwner, Observer {
            Picasso.get().load(it.image).resize(400, 400).into(poster)
            txtId?.setText(it.id)
            txtTitle?.setText(it.name)
            txtAuthor?.setText(it.author)
            txtDesc?.setText(it.desc)
            val library = it
            //update menanti!!!
        })
    }
}