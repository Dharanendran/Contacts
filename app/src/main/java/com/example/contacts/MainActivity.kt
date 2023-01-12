package com.example.contacts

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.contacts.presentation.view.FragmentAdapter
import com.example.contacts.presentation.view.FragmentAllContactsPage
import com.example.contacts.presentation.view.FragmentFavouritePage
import com.example.contacts.presentation.view.FragmentRecentSearch
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var viewpager:ViewPager
    lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {

        val height = Resources.getSystem().displayMetrics.heightPixels
        Log.v("get height",height.toString())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.tab_layout)
        setSupportActionBar(toolbar)

        viewpager = findViewById(R.id.view_pager)
        val fragments = mutableListOf( FragmentAllContactsPage(),
            FragmentFavouritePage(), FragmentRecentSearch()
        )
        val titles = mutableListOf("all","favourite","recents")
        viewpager.adapter = FragmentAdapter(fragments,titles ,supportFragmentManager)

        tabLayout = findViewById(R.id.tl)
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.getTabAt(0)?.setIcon(R.drawable.icon_all)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.icon_favourite)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.icon_recentsearch)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menus,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search  -> Toast.makeText(this,"search is clicked",Toast.LENGTH_SHORT).show()
            R.id.add     -> Toast.makeText(this,"add is clicked",Toast.LENGTH_SHORT).show()
            R.id.scanner -> Toast.makeText(this,"scanner is clicked",Toast.LENGTH_SHORT).show()
            R.id.delete  -> Toast.makeText(this,"delete is clicked",Toast.LENGTH_SHORT).show()
            R.id.share   -> Toast.makeText(this,"share is clicked",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}

