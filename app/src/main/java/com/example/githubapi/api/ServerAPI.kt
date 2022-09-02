package com.example.githubapi.api

import android.content.Context
import com.example.githubapi.model.BasicResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {
    companion object {
        private val baseUrl = "https://api.github.com"
        private var retrofit: Retrofit? = null

        fun getRetrofit(context: Context): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}