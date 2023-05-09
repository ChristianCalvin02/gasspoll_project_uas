package com.example.projectuts_ubayalibrary_160420034.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.model.Library

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
        TODO("Not yet implemented")
    }
}