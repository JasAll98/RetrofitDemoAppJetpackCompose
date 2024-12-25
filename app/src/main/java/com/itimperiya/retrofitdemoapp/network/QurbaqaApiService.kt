package com.itimperiya.retrofitdemoapp.network

import retrofit2.http.GET

interface QurbaqaApiService {
    @GET("amphibians")
    suspend fun getQurbaqalar(): List<Qurbaqa>
}
