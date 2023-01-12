package com.example.contacts.presentation.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.contacts.MainActivity
import com.example.contacts.R

class SplashActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.splash_screen)
        Handler().postDelayed({startActivity(Intent(this,MainActivity::class.java))
                               finish()},1000)
    }
}