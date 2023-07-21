package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.databinding.FragmentLibraryDetailBinding
import com.example.projectuts_ubayalibrary_160420034.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso

class LibraryDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentLibraryDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentLibraryDetailBinding>(
            inflater,
            R.layout.fragment_library_detail,
            container,
            false
        )
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_library_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        val id = LibraryDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.show(id)
        /*if(arguments != null){
            val id = LibraryDetailFragmentArgs.fromBundle(requireArguments()).id
            viewModel.show(id)
        }*/
        val btnSewa = view.findViewById<Button>(R.id.btnSewa)
        btnSewa.setOnClickListener {

        }

        ObserveViewModels()
    }

    fun ObserveViewModels(){
        viewModel.libraryLD.observe(viewLifecycleOwner, Observer {
            dataBinding.library = it
            val library = it
        })
        /*val txtId = view?.findViewById<TextView>(R.id.txtIdBook)
        val txtTitle = view?.findViewById<TextView>(R.id.txtTitleBook)
        val txtAuthor = view?.findViewById<TextView>(R.id.txtAuthor)
        val txtDesc = view?.findViewById<TextView>(R.id.txtDesc)
        val txtRating = view?.findViewById<TextView>(R.id.txtRating)
        val poster = view?.findViewById<ImageView>(R.id.imagePoster)

        viewModel.libraryLD.observe(viewLifecycleOwner, Observer {
            Picasso.get().load(it.image_url).resize(400, 400).into(poster)
            txtId?.setText(it.id)
            txtTitle?.setText(it.book_name)
            txtAuthor?.setText(it.author)
            txtDesc?.setText(it.description)
            txtRating?.setText(it.rating.toString())
            val library = it
        })*/
    }
}