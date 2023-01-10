package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.contacts.view.*
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var viewpager:ViewPager
    lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.tab_layout)
        setSupportActionBar(toolbar)

        viewpager = findViewById(R.id.view_pager)
        val fragments = mutableListOf(
            FragmentAllContactsPage(),
            FragmentFavouritePage(), FragmentRecentSearch()
        )
        val titles = mutableListOf("all","favourite","recent search")
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

