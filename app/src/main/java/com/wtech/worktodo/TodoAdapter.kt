package com.wtech.worktodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TodoAdapter(
    var todos:List<Todo>
) :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.tod_list,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            var tvTitle=findViewById<TextView>(R.id.titleList)
            var isDone=findViewById<CheckBox>(R.id.isDone)
            tvTitle.text=todos[position].title
            isDone.isChecked=todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}