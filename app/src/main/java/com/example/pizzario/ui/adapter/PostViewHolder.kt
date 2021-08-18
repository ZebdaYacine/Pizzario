package com.example.pizzario.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzario.R
import com.example.pizzario.model.Post

class PostViewHolder (inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_view,parent,false)) {

    private var title: TextView?=null
    private var body:TextView?=null


    init {
        title=itemView.findViewById(R.id.title)
        body=itemView.findViewById(R.id.body)
    }
    fun bind(post:Post) {
        title?.text=post.title
        body?.text=post.body
    }

}