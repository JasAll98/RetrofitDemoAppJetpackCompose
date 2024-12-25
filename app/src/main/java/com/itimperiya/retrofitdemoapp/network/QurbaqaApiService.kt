package com.itimperiya.retrofitdemoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface QurbaqaApiService {
    @GET("amphibians")
    suspend fun getQurbaqalar(): List<Qurbaqa>
}

object QurbaqaApi {
    val retrofitService: QurbaqaApiService by lazy {
        retrofit.create(QurbaqaApiService::class.java)
    }
}