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
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.util.loadImage

class RecomendedListAdapter(val recommendedList:ArrayList<Library>):
    RecyclerView.Adapter<RecomendedListAdapter.RecomendedViewHolder>() {

    class RecomendedViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.library_list_item, parent, false)
        return RecomendedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recommendedList.size
    }

    override fun onBindViewHolder(holder: RecomendedViewHolder, position: Int) {
        val txtId = holder.view.findViewById<TextView>(R.id.txtIdBook)
        val txtName = holder.view.findViewById<TextView>(R.id.txtBookName)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        txtId.text = recommendedList[position].id
        txtName.text = recommendedList[position].book_name
        btnDetail.setOnClickListener {
            val id = txtId.text.toString()
            val action = RecommendedBookFragmentDirections.actionItemRecomToRecommendDetailFragment(id)
            Navigation.findNavController(it).navigate(action)
        }

        var imageView = holder.view.findViewById<ImageView>(R.id.imageViewLibrary)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(recommendedList[position].image_url, progressBar!!)
    }

    fun updateLibraryList(newLibraryList: ArrayList<Library>){
        recommendedList.clear()
        recommendedList.addAll(newLibraryList)
        notifyDataSetChanged()
    }
}