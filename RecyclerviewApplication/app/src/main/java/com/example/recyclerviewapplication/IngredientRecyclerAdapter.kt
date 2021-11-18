package com.example.recyclerviewapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapplication.databinding.IngredientSingleItemBinding
import com.example.recyclerviewapplication.databinding.SingleItemBinding

class IngredientRecyclerAdapter : RecyclerView.Adapter<IngredientRecyclerAdapter.IngredientViewHolder>() {

    class IngredientViewHolder(binding : IngredientSingleItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {

        val binding = IngredientSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 15
    }
}