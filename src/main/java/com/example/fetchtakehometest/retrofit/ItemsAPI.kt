/*
Created By Nicholas Florschutz
Date: 11/23/2022
********************************************
I created this app for my coding take home test for Fetch Rewards
********************************************
*/
package com.example.fetchtakehometest.retrofit

import com.example.fetchtakehometest.data.RetrievedItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ItemsAPI {
    @GET("/hiring.json")
    suspend fun getAllItems(): Response<List<RetrievedItem>>

    companion object {
        private var itemsAPI: ItemsAPI? = null

        fun getInstance() : ItemsAPI {
            if (itemsAPI == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                itemsAPI = retrofit.create(ItemsAPI::class.java)
            }
            return itemsAPI!!
        }

    }
}