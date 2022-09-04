package com.example.githubapi.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapi.api.APIList
import com.example.githubapi.api.ServerAPI
import com.example.githubapi.model.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    private val _basicResponse = MutableLiveData<BasicResponse>()
    val basicResponse = _basicResponse
    private lateinit var apiList: APIList

    private fun getRetrofit() {
        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
    }

    fun getSearchList(query: String) {
        getRetrofit()
        apiList.getSearchRepositories(query).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                val br = response.body()
                val totalCount = br?.totalCount
                Log.d("__totalCount", totalCount.toString())
                val boolean = br?.incompleteResults
                Log.d("__boolean", boolean.toString())
                val items = br?.items
                Log.d("__items", items.toString())
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {}
        })
    }

}