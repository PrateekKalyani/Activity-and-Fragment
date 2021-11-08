package com.example.fragmentpraticeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var switchButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchButton = findViewById(R.id.switchButton)

        switchButton.setOnClickListener {

            var currentFragment = supportFragmentManager.findFragmentById(R.id.frameContainer)

            if (currentFragment == null || currentFragment is SecondFragment)
            {
                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, FirstFragment()).commit()
            }
            else
            {
                supportFragmentManager.beginTransaction().replace(R.id.frameContainer, SecondFragment()).commit()
            }

        }
    }
}