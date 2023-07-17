package com.example.projectuts_ubayalibrary_160420034.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.databinding.LibraryListItemBinding
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.util.loadImage

class RecomendedListAdapter(val recommendedList:ArrayList<Library>):
    RecyclerView.Adapter<RecomendedListAdapter.RecomendedViewHolder>() , ButtonDetailClickListener{

    class RecomendedViewHolder(var view: LibraryListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = LibraryListItemBinding.inflate(inflater, parent, false)
        return RecomendedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recommendedList.size
    }

    override fun onBindViewHolder(holder: RecomendedViewHolder, position: Int) {
        holder.view.library = recommendedList[position]
        holder.view.listener = this
        /*val txtId = holder.view.findViewById<TextView>(R.id.txtNameBook)
        val txtName = holder.view.findViewById<TextView>(R.id.txtAuthorBook)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        txtId.text = recommendedList[position].id.toString()
        txtName.text = recommendedList[position].book_name
        btnDetail.setOnClickListener {
            val id = txtId.text.toString().toInt()
            val action = RecommendedBookFragmentDirections.actionItemRecomToRecommendDetailFragment(id)
            Navigation.findNavController(it).navigate(action)
        }

        var imageView = holder.view.findViewById<ImageView>(R.id.imageViewLibrary)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(recommendedList[position].image_url, progressBar!!)*/
    }

    fun updateLibraryList(newLibraryList: List<Library>){
        recommendedList.clear()
        recommendedList.addAll(newLibraryList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val id = v.tag.toString().toInt()
        val action = RecommendedBookFragmentDirections.actionItemRecomToRecommendDetailFragment(id)
        Navigation.findNavController(v).navigate(action)
    }
}