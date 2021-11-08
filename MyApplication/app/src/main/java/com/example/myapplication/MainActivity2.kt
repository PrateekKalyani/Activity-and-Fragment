package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        println("Lifecycle Second Activity - onCreate Invoked")
    }

    override fun onStart()
    {
        super.onStart()
        println("Lifecycle Second Activity - onStart Invoked")
    }

    override fun onResume() {
        super.onResume()
        println("Lifecycle Second Activity - onResume Invoked")
    }

    override fun onRestart() {
        super.onRestart()
        println("Lifecycle Second Activity - onRestart Invoked")
    }

    override fun onPause() {
        super.onPause()
        println("Lifecycle Second Activity - onPause Invoked")
    }

    override fun onStop() {
        super.onStop()
        println("Lifecycle Second Activity - onStop Invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Lifecycle Second Activity - onDestroy Invoked")
    }
}