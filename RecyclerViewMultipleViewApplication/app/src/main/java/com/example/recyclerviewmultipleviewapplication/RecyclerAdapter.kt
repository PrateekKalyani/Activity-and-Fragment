package com.example.recyclerviewmultipleviewapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmultipleviewapplication.databinding.ActivityMainBinding
import com.example.recyclerviewmultipleviewapplication.databinding.ItemType1Binding
import com.example.recyclerviewmultipleviewapplication.databinding.ItemType2Binding

class RecyclerAdapter(private val context: Context) :  RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val Item_Type_1 = 1
        const val Item_Type_2 = 2
    }

    class RecyclerView1Holder(private val binding: ItemType1Binding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context) {
            binding.layout.setOnClickListener {
                Toast.makeText(
                    context,
                    "You clicked Item 1",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    class RecyclerView2Holder(private val binding: ItemType2Binding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(context: Context) {
            binding.layout.setOnClickListener {
                Toast.makeText(
                    context,
                    "You clicked Item 2",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == Item_Type_1) {
            val binding = ItemType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RecyclerView1Holder(binding = binding)
        }

        val binding = ItemType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerView2Holder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position % 2) {

            0 -> {
                (holder as RecyclerView1Holder).bind(context = context)
            }

            1 -> {
                (holder as RecyclerView2Holder).bind(context = context)
            }
        }
    }

    override fun getItemCount(): Int {
        return 16
    }

    override fun getItemViewType(position: Int): Int {

        if(position % 2 == 0) {
            return Item_Type_1
        } else {
            return Item_Type_2
        }

        return super.getItemViewType(position)
    }
}