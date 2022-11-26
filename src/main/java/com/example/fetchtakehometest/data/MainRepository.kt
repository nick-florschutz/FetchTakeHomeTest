/*
Created By Nicholas Florschutz
Date: 11/23/2022
********************************************
I created this app for my coding take home test for Fetch Rewards
********************************************
*/
package com.example.fetchtakehometest.data

import com.example.fetchtakehometest.retrofit.ItemsAPI

class MainRepository(private val itemsAPI: ItemsAPI) {

    suspend fun getAllItems() = itemsAPI.getAllItems()

}