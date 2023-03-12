package ru.artbez.shopapptest.api

import retrofit2.Response
import retrofit2.http.GET
import ru.artbez.shopapptest.models.FlashsaleModel
import ru.artbez.shopapptest.models.LatestModel

interface ApiService {

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): Response<LatestModel>

    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashsale(): Response<FlashsaleModel>

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getBrands(): Response<LatestModel>

}