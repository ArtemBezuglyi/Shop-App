package ru.artbez.shopapptest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.artbez.shopapptest.BASE_URL

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}