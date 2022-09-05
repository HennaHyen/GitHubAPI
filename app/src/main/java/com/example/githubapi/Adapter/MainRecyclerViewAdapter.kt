package com.example.githubapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.R
import com.example.githubapi.model.ItemsData

class MainRecyclerViewAdapter(var items: ArrayList<ItemsData>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val id = view.findViewById<TextView>(R.id.resultId)
        private val name = view.findViewById<TextView>(R.id.resultName)

        fun bind(item: ItemsData) {
            id.text = item.id.toString()
            name.text = item.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerViewAdapter.ItemViewHolder {
        val row = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_recycler_view, parent, false)
        return ItemViewHolder(row)
    }

    override fun onBindViewHolder(holder: MainRecyclerViewAdapter.ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setNewItems(newItems: ArrayList<ItemsData>) {
        items = newItems
        notifyDataSetChanged()
    }
}