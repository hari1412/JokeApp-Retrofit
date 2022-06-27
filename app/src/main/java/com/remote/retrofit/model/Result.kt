package com.remote.retrofit.model

data class Result(
    val _id: Int,
    val lang: String,
    val safe: Boolean,
    val category: String,
    val type: String,
    val setup: String,
    val delivery: String,
    val joke: String
)
