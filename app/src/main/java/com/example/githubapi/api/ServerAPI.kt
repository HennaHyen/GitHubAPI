package com.example.githubapi.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

    companion object {
        private const val baseUrl = "https://api.github.com"
        private lateinit var retrofit: Retrofit

        fun getRetrofit(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}