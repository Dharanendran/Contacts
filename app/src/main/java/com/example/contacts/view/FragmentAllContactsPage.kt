package com.example.contacts.view

import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.models.Contact

var contactId:Int = 0
class FragmentAllContactsPage : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var toolbar: Toolbar
    private val allContacts = mutableListOf<Contact>()


    init {
        for (i in 1..100) {
            contactId++
            allContacts.add(
                Contact(
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
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_viewpager, container, false)
        recyclerView = view.findViewById(R.id.rv)
        recyclerView.adapter = ViewPageRvAdapter(allContacts,ViewPageRvAdapter.PageType.ALLCONTACTS)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        return view
    }
}
