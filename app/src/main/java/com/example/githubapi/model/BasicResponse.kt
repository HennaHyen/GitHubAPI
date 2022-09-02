package com.example.githubapi.model

import java.util.*

data class BasicResponse(
    val url: String,
    val files: FilesData,
    val truncated: Boolean,
    val createdAt: Date,
    val comments: Int
)