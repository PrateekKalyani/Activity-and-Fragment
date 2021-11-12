package com.example.layoutpraticeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layoutpraticeapplication.databinding.ActivityMainBinding
import com.example.layoutpraticeapplication.databinding.ActivitySettingsLinearBinding

class SettingsLinearActivity : AppCompatActivity() {

    lateinit var binding : ActivitySettingsLinearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsLinearBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}