package com.example.recyclerviewmultipleviewapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmultipleviewapplication.databinding.ChatViewOneBinding
import com.example.recyclerviewmultipleviewapplication.databinding.ChatViewSecondBinding
import java.lang.IllegalArgumentException

class ChatAdapter(private val chatList : MutableList<ChatModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val VIEW_TYPE_1 = 1
        const val VIEW_TYPE_2 = 2
    }

    class ChatViewHolder1(private val binding : ChatViewOneBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(message : String) {
            binding.messageText.text = message
        }
    }

    class ChatViewHolder2(private val binding: ChatViewSecondBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(message : String) {
            binding.messageText.text = message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType) {

            VIEW_TYPE_1 -> {
                val binding = ChatViewOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ChatViewHolder1(binding = binding)
            }

            VIEW_TYPE_2 -> {
                val binding = ChatViewSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ChatViewHolder2(binding = binding)
            }

            else -> {
                throw IllegalArgumentException("View type not Found $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(chatList[position].viewType) {

            VIEW_TYPE_1 -> {
                (holder as ChatViewHolder1).bind(message = chatList[position].text)
            }

            VIEW_TYPE_2 -> {
                (holder as ChatViewHolder2).bind(message = chatList[position].text)
            }
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun getItemViewType(position: Int): Int {
        return chatList[position].viewType
    }
}