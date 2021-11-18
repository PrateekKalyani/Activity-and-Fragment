package com.example.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , TodoAdapter.TodoInterface{

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var todoList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        createRecyclerView()

        binding.addButton.setOnClickListener {
            addTask()
        }
    }

    private fun createRecyclerView()
    {
        binding.todoRecycler.layoutManager = LinearLayoutManager(this@MainActivity)

        val adapter  = TodoAdapter(todoList)
        adapter.setInterface(this)

        binding.todoRecycler.adapter = adapter
    }

    private fun addTask()
    {
        val task = binding.editText.text.toString()

        if(task.isEmpty())
        {
            return
        }

        todoList.add(task)

        binding.editText.text.clear()
        binding.todoRecycler.adapter!!.notifyItemInserted(todoList.size - 1)
    }

    override fun deleteTask(position: Int) {

        Toast.makeText(this@MainActivity, "you clicked at $position", Toast.LENGTH_SHORT).show()

        todoList.removeAt(position)

        binding.todoRecycler.adapter!!.notifyItemRemoved(position)
        binding.todoRecycler.adapter!!.notifyItemRangeChanged(position, todoList.size );
    }
}