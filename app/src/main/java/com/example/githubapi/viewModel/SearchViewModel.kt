package com.example.githubapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapi.api.APIList
import com.example.githubapi.api.ServerAPI
import com.example.githubapi.model.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private lateinit var apiList: APIList
    private val _basicResponse: MutableLiveData<BasicResponse> = MutableLiveData<BasicResponse>()
    val basicResponse: LiveData<BasicResponse> = _basicResponse

    private fun initRetrofit() {
        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
    }

    fun getSearchRepositories(query: String) {
        initRetrofit()
        apiList.getSearchRepositories(query).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                val br = response.body()!! //body는 항상 널이 아니여야하는데 이럴 경우에도 ?를 써야하는지
                val totalCount = br.totalCount
                val boolean = br.incompleteResults
                val items = br.items
                _basicResponse.value = BasicResponse(totalCount, boolean, items)
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {}
        })
    }
}