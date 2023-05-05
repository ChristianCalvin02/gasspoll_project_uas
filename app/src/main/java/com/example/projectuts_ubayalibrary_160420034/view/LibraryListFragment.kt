package com.example.projectuts_ubayalibrary_160420034.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.projectuts_ubayalibrary_160420034.R
import com.example.projectuts_ubayalibrary_160420034.viewmodel.ListViewModel

class LibraryListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private var libraryListAdapter = LibraryListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recView =view.findViewById<RecyclerView>(R.id.recyclerView)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = libraryListAdapter

        observeViewModel()

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        swipe.setOnRefreshListener {
            recView.visibility = View.GONE
            val txtError = view?.findViewById<TextView>(R.id.txtError)
            txtError?.visibility = View.GONE
            val progressLoad = view?.findViewById<TextView>(R.id.progressBar)
            progressLoad?.visibility = View.GONE

            viewModel.refresh()
            swipe.isRefreshing = false
        }
    }

    fun observeViewModel(){
        viewModel.libraryLD.observe(viewLifecycleOwner, Observer{

        })
    }
}