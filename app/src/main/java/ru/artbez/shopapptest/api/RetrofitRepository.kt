package ru.artbez.shopapptest.api

import retrofit2.Response
import ru.artbez.shopapptest.models.FlashsaleModel
import ru.artbez.shopapptest.models.LatestModel

class RetrofitRepository {

    suspend fun getGoodsLatest(): Response<LatestModel> {
        return RetrofitInstance.api.getLatest()
    }

    suspend fun getGoodsFlashsale(): Response<FlashsaleModel> {
        return RetrofitInstance.api.getFlashsale()
    }

    suspend fun getGoodsBrands(): Response<LatestModel> {
        return RetrofitInstance.api.getBrands()
    }

}
