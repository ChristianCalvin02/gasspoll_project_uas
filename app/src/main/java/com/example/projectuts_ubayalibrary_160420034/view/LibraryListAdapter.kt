package com.example.projectuts_ubayalibrary_160420034.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.databinding.LibraryListItemBinding
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.util.loadImage
import com.example.projectuts_ubayalibrary_160420034.viewmodel.DetailViewModel
import com.example.projectuts_ubayalibrary_160420034.viewmodel.RecommendDetailViewModel

class LibraryListAdapter(val libraryList:ArrayList<Library>):
    RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder>()
    , ButtonDetailClickListener {
    class LibraryViewHolder(var view: LibraryListItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LibraryViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val view = LibraryListItemBinding.inflate(inflater, parent, false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        holder.view.library =libraryList[position]
        holder.view.listener = this
        /*val txtId = holder.view.findViewById<TextView>(R.id.txtIdBook)
        val txtName = holder.view.findViewById<TextView>(R.id.txtBookName)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        txtId.text = libraryList[position].id
        txtName.text = libraryList[position].book_name*/
        /*btnDetail.setOnClickListener {
            val id = txtId.text.toString()
            val action = LibraryListFragmentDirections.actionLibraryDetail(id)
            Navigation.findNavController(it).navigate(action)
        }*/

        /*var imageView = holder.view.findViewById<ImageView>(R.id.imageViewLibrary)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(libraryList[position].image_url, progressBar!!)*/
    }

    override fun getItemCount(): Int {
        return libraryList.size
    }
    fun updateLibraryList(newLibraryList: List<Library>){
        libraryList.clear()
        libraryList.addAll(newLibraryList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val id = v.tag.toString().toInt()
        val action = LibraryListFragmentDirections.actionLibraryDetail(id)
        Navigation.findNavController(v).navigate(action)
    }
}

