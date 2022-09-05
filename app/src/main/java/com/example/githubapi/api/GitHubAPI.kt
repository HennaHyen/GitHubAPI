package com.example.githubapi.api

import com.example.githubapi.model.BasicResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubAPI {

    @GET("/search/repositories")
    fun getSearchRepositories(
        @Query("q") query: String
    ): Call<BasicResponse>
}