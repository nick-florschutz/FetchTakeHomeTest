/*
Created By Nicholas Florschutz
Date: 11/23/2022
********************************************
I created this app for my coding take home test for Fetch Rewards
********************************************
*/
package com.example.fetchtakehometest.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.*

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    private val errorMessage = MutableLiveData<String>()
    private var job: Job? = null
    private val loading = MutableLiveData<Boolean>()
    val itemList = MutableLiveData<List<RetrievedItem>?>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getAllItems() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getAllItems()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    /*
                        * return zero if object1 is equal object2
                        * a negative number if object1 is less than object2
                        * a positive number if object1 is greater than object2
                     */
                    itemList.value = response.body()
                        ?.sortedWith(object : Comparator <RetrievedItem> {
                            override fun compare (p0: RetrievedItem, pi: RetrievedItem) : Int {
                                if (p0.name.isNullOrEmpty()){
                                    return -1
                                }
                                if(pi.name.isNullOrEmpty()){
                                    return 1
                                }
                                if (p0.name.substring(5).toInt() > pi.name.substring(5).toInt()) {
                                    return 1
                                }
                                if (p0.name == pi.name) {
                                    return 0
                                }
                                return -1
                            }
                        })
                        ?.sortedBy { it.listId }
                        ?.filter { !it.name.isNullOrEmpty() }

                    loading.value = false

                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}