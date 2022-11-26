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
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchtakehometest.R
import com.example.fetchtakehometest.data.RetrievedItem

class ItemsListViewHolder(private val view: View): RecyclerView.ViewHolder(view)  {

    fun onBind(item: RetrievedItem){
        // Setting the name of the item
        view.findViewById<TextView>(R.id.tvItemName).text = view.resources.getString(R.string.name)
            .format(item.name)
        // Setting the id of the item
        view.findViewById<TextView>(R.id.tvItemID).text = view.resources.getString(R.string.id)
            .format(item.id)
        // Setting the listID of the item
        view.findViewById<TextView>(R.id.tvItemListID).text = view.resources.getString(R.string.listID)
            .format(item.listId)
    }

}