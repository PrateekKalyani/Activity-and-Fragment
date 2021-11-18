package com.example.recyclerviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , RecyclerViewAdapter.ItemClickListener{

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RecyclerViewAdapter()
        adapter.setItemClickListener(this)
        binding.recyclerView.adapter = adapter

        binding.IngredientRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.IngredientRecyclerView.adapter = IngredientRecyclerAdapter()
    }

    override fun itemClick(position: Int) {

        val message = "You click at item : $position"

        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}