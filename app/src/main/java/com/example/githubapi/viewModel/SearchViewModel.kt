package com.example.githubapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapi.api.GitHubAPI
import com.example.githubapi.api.ServerAPI
import com.example.githubapi.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private lateinit var gitHubAPI: GitHubAPI
    private val _searchResponse: MutableLiveData<SearchResponse> = MutableLiveData<SearchResponse>()
    val searchResponse: LiveData<SearchResponse> = _searchResponse

    private fun initRetrofit() {
        val retrofit = ServerAPI.getRetrofit()
        gitHubAPI = retrofit.create(GitHubAPI::class.java)
    }

    fun getSearchRepositories(query: String) {
        initRetrofit()

        gitHubAPI.getSearchRepositories(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val br = response.body()!!
                    val totalCount = br.totalCount
                    val boolean = br.incompleteResults
                    val items = br.items

                    _searchResponse.value = SearchResponse(totalCount, boolean, items)
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {}
        })
    }
}