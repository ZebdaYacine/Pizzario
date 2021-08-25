package com.example.pizzario.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzario.R
import com.example.pizzario.data.model.Category

class CategoryViewHolder (inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.category_item_view,parent,false)) {

    private var name: TextView?=null

    init {
        name=itemView.findViewById(R.id.name)
    }
    fun bind(category: Category) {
        name?.text=category.name
    }

}