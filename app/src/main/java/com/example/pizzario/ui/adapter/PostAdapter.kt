package com.example.pizzario.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzario.R
import com.example.pizzario.model.Post
import com.example.pizzario.ui.home.HomeViewModel


class PostAdapter(private val items:ArrayList<Post>, private val listener: (Post) -> Unit)
    :RecyclerView.Adapter<PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PostViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val movie: Post = items[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener{ listener(movie) }
    }

    override fun getItemCount(): Int = items.size
}