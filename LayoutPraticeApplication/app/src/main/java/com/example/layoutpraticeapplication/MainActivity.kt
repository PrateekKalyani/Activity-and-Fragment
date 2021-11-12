package com.example.layoutpraticeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.layoutpraticeapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener {

            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            val message = "Username entered is $username and password entered is $password"

            Toast.makeText(this@MainActivity, message , Toast.LENGTH_LONG).show()
        }

        binding.switchButton.setOnClickListener {

            val intent = Intent(this@MainActivity, SettingsRelativeActivity::class.java)
            startActivity(intent)
        }
    }
}