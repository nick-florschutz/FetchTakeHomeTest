/*
Created By Nicholas Florschutz
Date: 11/23/2022
********************************************
I created this app for my coding take home test for Fetch Rewards
********************************************
*/
package com.example.fetchtakehometest.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchtakehometest.R
import com.example.fetchtakehometest.data.RetrievedItem

class ItemsListViewHolder(private val view: View): RecyclerView.ViewHolder(view)  {

    fun onBind(item: RetrievedItem){
        view.findViewById<TextView>(R.id.tvItemName).text = item.name
        view.findViewById<TextView>(R.id.tvItemID).text = item.id.toString()
        view.findViewById<TextView>(R.id.tvItemListID).text = item.listId.toString()
    }

}