package com.example.githubapi.api

import com.example.githubapi.model.BasicResponse
import com.example.githubapi.model.FilesData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface APIList {
    @GET("/gists/public")
    fun getListPublicGists(
        @Query("url") url: String,
        @Query("files") files: FilesData,
        @Query("truncated") truncated: Boolean,
        @Query("createdAt") createdAt: Date,
        @Query("comments") comments: Int
    ): Call<BasicResponse>
}