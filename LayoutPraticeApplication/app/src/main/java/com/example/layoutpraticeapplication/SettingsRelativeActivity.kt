package com.example.layoutpraticeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layoutpraticeapplication.databinding.ActivityMainBinding
import com.example.layoutpraticeapplication.databinding.ActivitySettingsRelativeBinding

class SettingsRelativeActivity : AppCompatActivity() {

    lateinit var binding : ActivitySettingsRelativeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySettingsRelativeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.switchButton.setOnClickListener {

            var intent = Intent(this, SettingsLinearActivity::class.java)
            startActivity(intent)
        }
    }
}