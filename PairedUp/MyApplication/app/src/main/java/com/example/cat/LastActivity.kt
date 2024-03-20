package com.example.cat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class LastActivity : AppCompatActivity() {
    private lateinit var againB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)
        initExitComponents()
        setupExitListeners()
    }

    private fun initExitComponents() {
        againB = findViewById(R.id.button5)
    }

    private fun setupExitListeners() {
        againB.setOnClickListener { onAgainClicked() }


    }

    private fun onAgainClicked() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }
}