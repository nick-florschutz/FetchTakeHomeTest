/*
Created By Nicholas Florschutz
Date: 11/23/2022
********************************************
I created this app for my coding take home test for Fetch Rewards
********************************************
*/
package com.example.fetchtakehometest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchtakehometest.R
import com.example.fetchtakehometest.data.RetrievedItem
import com.example.fetchtakehometest.viewHolders.ItemsListViewHolder

class ItemsListAdapter() : RecyclerView.Adapter<ItemsListViewHolder>()   {

    private var itemList = ArrayList<RetrievedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsListViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setItemList(itemList : List<RetrievedItem>){
        this.itemList = itemList as ArrayList<RetrievedItem>
        notifyDataSetChanged()
    }
}