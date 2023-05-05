package com.example.projectuts_ubayalibrary_160420034.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.util.loadImage

class LibraryListAdapter(val libraryList:ArrayList<Library>):
    RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder>(){
    class LibraryViewHolder(var view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LibraryViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.library_list_item, parent, false)
        return LibraryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return libraryList.size
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val txtId = holder.view.findViewById<TextView>(R.id.txtIdBook)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        holder.view.findViewById<TextView>(R.id.txtIdBook).text = libraryList[position].id
        holder.view.findViewById<TextView>(R.id.txtBookName).text = libraryList[position].name
        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener {
            val id = txtId.text.toString()
        }
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar =holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(libraryList[position].image, progressBar)
    }

    fun updateLibraryList(newLibraryList: ArrayList<Library>){
        libraryList.clear()
        libraryList.addAll(newLibraryList)
        notifyDataSetChanged()
    }
}

