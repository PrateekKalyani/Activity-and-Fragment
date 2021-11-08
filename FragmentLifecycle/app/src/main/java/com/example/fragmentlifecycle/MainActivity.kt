package com.example.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    lateinit var frameContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Lifecycle Main Activity - onStart Invoked")

        addFragment()
    }

    private fun addFragment()
    {
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameContainer, BlankFragment())
        fragmentTransaction.addToBackStack("Blank Fragment")
        fragmentTransaction.commit()
    }

    override fun onStart()
    {
        super.onStart()
        println("Lifecycle Main Activity - onStart Invoked")
    }

    override fun onResume() {
        super.onResume()
        println("Lifecycle Main Activity - onResume Invoked")
    }

    override fun onRestart() {
        super.onRestart()
        println("Lifecycle Main Activity - onRestart Invoked")
    }

    override fun onPause() {
        super.onPause()
        println("Lifecycle Main Activity - onPause Invoked")
    }

    override fun onStop() {
        super.onStop()
        println("Lifecycle Main Activity - onStop Invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Lifecycle Main Activity - onDestroy Invoked")
    }
}