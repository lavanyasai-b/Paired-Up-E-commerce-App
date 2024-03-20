package com.example.cat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    private lateinit var readyB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initReadyComponents()
        setupReadyListeners()
    }


    private fun initReadyComponents() {
        readyB = findViewById(R.id.button6)
    }

    private fun setupReadyListeners() {
        readyB.setOnClickListener { onReadyClicked() }



    }
    private fun onReadyClicked() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }
}