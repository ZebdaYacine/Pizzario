package com.example.pizzario.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzario.model.Category


class CategoryAdapter(private val items:ArrayList<Category>, private val listener: (Category) -> Unit)
    :RecyclerView.Adapter<CategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val movie: Category = items[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener{ listener(movie) }
    }

    override fun getItemCount(): Int = items.size
}