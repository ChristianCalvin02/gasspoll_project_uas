package com.example.projectuts_ubayalibrary_160420034.view

import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.model.Library
import com.example.projectuts_ubayalibrary_160420034.util.loadImage

class RatingListAdapter(val ratingList:ArrayList<Library>):
    RecyclerView.Adapter<RatingListAdapter.RatingViewHolder>(){
    class RatingViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rating_list_item, parent, false)
        return RatingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ratingList.size
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        val txtId = holder.view.findViewById<TextView>(R.id.txtIdBookRat)
        val txtName = holder.view.findViewById<TextView>(R.id.txtBookTitleRating)
        val rating = holder.view.findViewById<RatingBar>(R.id.ratingBook)
        txtId.text = ratingList[position].id.toString()
        txtName.text = ratingList[position].book_name
        rating.rating = ratingList[position].rating.toFloat()

        var imageView = holder.view.findViewById<ImageView>(R.id.imageViewRating)
        var progressLoad = holder.view.findViewById<ProgressBar>(R.id.progressLoadRating)
        imageView.loadImage(ratingList[position].image_url, progressLoad!!)
    }

    fun updateRatingList(newLibraryList: List<Library>){
        ratingList.clear()
        ratingList.addAll(newLibraryList)
        notifyDataSetChanged()
    }
}