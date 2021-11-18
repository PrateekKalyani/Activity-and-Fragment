package com.example.todoapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.databinding.ActivityMainBinding
import com.example.todoapplication.databinding.SingleTaskItemBinding

class TodoAdapter(private val todoList : MutableList<String>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()  {

    lateinit var todoInterface : TodoInterface

    class TodoViewHolder(private val binding : SingleTaskItemBinding, private val todoInterface: TodoInterface) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(task : String, position: Int)
        {
            binding.taskText.text = task

            binding.deleteButton.setOnClickListener {
                todoInterface.deleteTask(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        var binding = SingleTaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding, todoInterface)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.bind(todoList[position], position)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun setInterface(currentInterface : TodoInterface)
    {
        todoInterface = currentInterface
    }

    interface TodoInterface
    {
        fun deleteTask(position: Int)
    }

}