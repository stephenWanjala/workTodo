package com.wtech.worktodo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var  todoRecyclerview:RecyclerView
    private lateinit var btnAdd:Button
    private lateinit var etAddTodo:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todoList= mutableListOf(
            Todo("follow devs",false),
            Todo("Go to church",true)
        )
        val adapter=TodoAdapter(todoList)
        todoRecyclerview=findViewById(R.id.todoRecyclerview)
        todoRecyclerview.adapter=adapter
        todoRecyclerview.layoutManager=LinearLayoutManager(this)
        btnAdd=findViewById(R.id.btn_add)
        etAddTodo=findViewById(R.id.etAddTodo)
        btnAdd.setOnClickListener {
            val title=etAddTodo.text.toString()

                if (title.isNotEmpty()){
                    todoList.add(Todo(title,false))
                    adapter.notifyItemInserted(todoList.size-1)
        }
        }
    }
}