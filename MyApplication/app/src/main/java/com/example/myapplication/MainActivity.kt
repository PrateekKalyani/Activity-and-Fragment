package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Lifecycle First Activity - onCreate Invoked")

        button = findViewById(R.id.button1)

        button.setOnClickListener {

            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart()
    {
        super.onStart()
        println("Lifecycle First Activity - onStart Invoked")
    }

    override fun onResume() {
        super.onResume()
        println("Lifecycle First Activity - onResume Invoked")
    }

    override fun onRestart() {
        super.onRestart()
        println("Lifecycle First Activity - onRestart Invoked")
    }

    override fun onPause() {
        super.onPause()
        println("Lifecycle First Activity - onPause Invoked")
    }

    override fun onStop() {
        super.onStop()
        println("Lifecycle First Activity - onStop Invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Lifecycle First Activity - onDestroy Invoked")
    }
}