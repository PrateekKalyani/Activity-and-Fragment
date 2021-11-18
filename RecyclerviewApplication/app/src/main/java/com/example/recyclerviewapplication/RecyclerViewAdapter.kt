package com.example.recyclerviewapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapplication.databinding.SingleItemBinding

public class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    lateinit var clickListenter : ItemClickListener

    public class ViewHolder(private val binding: SingleItemBinding, private val clickListenter : ItemClickListener) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(position: Int)
        {
            binding.textview.text = (position + 1).toString()

            binding.itemLayout.setOnClickListener {

                clickListenter.itemClick(position)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, clickListenter)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position)
    }

    fun setItemClickListener(listener : ItemClickListener)
    {
        this.clickListenter = listener
    }

    override fun getItemCount(): Int {
        return 15
    }

    interface ItemClickListener
    {
        fun itemClick(position: Int)
    }
}