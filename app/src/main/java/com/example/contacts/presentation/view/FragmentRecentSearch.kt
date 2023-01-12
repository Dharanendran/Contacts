package com.example.contacts.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.domain.businessModel.ContactBook

class FragmentRecentSearch: Fragment(){

    lateinit var fragmentView:View
    lateinit var fragmentRecyclerView: RecyclerView
    private val recentSearches = mutableListOf<ContactBook>()
    init {
        for (i in 1..100)
            recentSearches.add(
                ContactBook(
                    "contact",
                    "$i",
                    null,
                    "qwewqe",
                    "1312321321",
                    null,
                    null,
                    null,
                    null,
                    null
                )
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentView = inflater.inflate(R.layout.fragment_viewpager,container,false)
        fragmentRecyclerView = fragmentView.findViewById(R.id.rv)
        fragmentRecyclerView.adapter = ViewPageRvAdapter(recentSearches, ViewPageRvAdapter.PageType.RECENTSEARCH)
        fragmentRecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        return fragmentView
    }
}