/*
Created By Nicholas Florschutz
Date: 11/23/2022
********************************************
I created this app for my coding take home test for Fetch Rewards
********************************************
*/
package com.example.fetchtakehometest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchtakehometest.adapters.ItemsListAdapter
import com.example.fetchtakehometest.data.MainRepository
import com.example.fetchtakehometest.data.RetrievedItem
import com.example.fetchtakehometest.data.MainViewModel
import com.example.fetchtakehometest.retrofit.ItemsAPI

class MainActivity : AppCompatActivity() {

    private lateinit var itemsList: ArrayList<RetrievedItem>
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: ItemsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // on below line we are initializing a list for our items
        itemsList = ArrayList()

        // Setting up the API call for Retrofit
        val retrofitService = ItemsAPI.getInstance()
        val mainRepository = MainRepository(retrofitService)

        mainViewModel =
            ViewModelProvider(this, MyViewModelFactory(mainRepository))[MainViewModel::class.java]

        //  Initialize the Recycler view
        adapter = ItemsListAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.rvItemsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.scheduleLayoutAnimation()

        //Observe and set the items in the RecyclerView
        mainViewModel.itemList.observe(this, Observer { list ->
            if (list != null) {
                adapter.setItemList(list)
            }
        })

        mainViewModel.getAllItems()

    }
}