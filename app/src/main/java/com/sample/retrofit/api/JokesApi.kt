package com.sample.retrofit.api

import com.sample.retrofit.model.JokesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {
    @GET("/joke/Any?type=single&")
    fun fetchJockes(@Query("amount") amount: String): Call<JokesList>
}