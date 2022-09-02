package com.example.githubapi.api

import retrofit2.Retrofit

class ServerAPI {
    companion object {
        private val baseUrl = "https://api.github.com"
        private var retrofit: Retrofit? = null
    }
}