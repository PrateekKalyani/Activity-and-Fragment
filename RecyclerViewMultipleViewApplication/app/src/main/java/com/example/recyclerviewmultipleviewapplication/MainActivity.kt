package com.example.recyclerviewmultipleviewapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmultipleviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {  ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()

        binding.switchButton.setOnClickListener {
            startActivity(Intent(
                this@MainActivity,
                ChatActivity::class.java
            ))
        }
    }

    private fun setRecyclerView() {

        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerAdapter(this@MainActivity)
        }
    }
}