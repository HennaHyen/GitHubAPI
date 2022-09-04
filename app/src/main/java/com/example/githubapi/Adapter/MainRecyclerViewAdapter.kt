package com.example.githubapi.Adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.model.ItemsData

class MainRecyclerViewAdapter(val memberList: ArrayList<ItemsData>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerViewAdapter.ItemViewHolder {

    }

    override fun onBindViewHolder(holder: MainRecyclerViewAdapter.ItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}