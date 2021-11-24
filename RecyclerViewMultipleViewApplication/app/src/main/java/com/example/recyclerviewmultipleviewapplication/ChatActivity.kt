package com.example.recyclerviewmultipleviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmultipleviewapplication.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private val binding by lazy { ActivityChatBinding.inflate(layoutInflater) }
    private val chatList by lazy { mutableListOf<ChatModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()

        binding.person1Button.setOnClickListener {
            addText(viewType = ChatAdapter.VIEW_TYPE_1)
        }

        binding.person2Button.setOnClickListener {
            addText(viewType = ChatAdapter.VIEW_TYPE_2)
        }
    }

    private fun addText(viewType : Int) {

        var messageText = binding.messageEditText.text.toString()

        if(messageText.isEmpty()) {
            return
        }

        chatList.add(ChatModel(
            text = messageText,
            viewType = viewType
        ))

        binding.messageEditText.setText("")
        binding.chatRecyclerView.adapter!!.notifyItemInserted(chatList.size - 1)
    }

    private fun setRecyclerView() {

        binding.chatRecyclerView.run {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = ChatAdapter(chatList)
        }
    }
}