package com.example.launchmodesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {

    lateinit var firstActivityButton : Button
    lateinit var secondActivityButton : Button
    lateinit var thirdActivityButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        firstActivityButton = findViewById(R.id.firstActivityButton)
        secondActivityButton = findViewById(R.id.secondActivityButton)
        thirdActivityButton = findViewById(R.id.thirdActivityButton)


        firstActivityButton.setOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        secondActivityButton.setOnClickListener {

            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        thirdActivityButton.setOnClickListener {

            var intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}