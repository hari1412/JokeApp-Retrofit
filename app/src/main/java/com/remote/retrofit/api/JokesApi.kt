package com.remote.retrofit.api

import com.remote.retrofit.model.JokesList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {
    @GET("/joke/Any?type=single&")
    fun fetchQuestions(@Query("amount") amount: String): Call<JokesList>
}