package com.onet.kanyefunquotes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://api.kanye.rest/").
        addConverterFactory(GsonConverterFactory.create()).build()
    val quotesService: ApiService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("/")
    suspend fun getQuote(): QuoteResponse
}