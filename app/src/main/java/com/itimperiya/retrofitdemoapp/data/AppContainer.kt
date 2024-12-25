package com.itimperiya.retrofitdemoapp.data

import com.itimperiya.retrofitdemoapp.network.QurbaqaApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val qurbaqaRepository: QurbaqaRepository
}

class DefaultAppContainer: AppContainer {

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: QurbaqaApiService by lazy {
        retrofit.create(QurbaqaApiService::class.java)
    }

    override val qurbaqaRepository: QurbaqaRepository by lazy {
        NetworkQurbaqaRepository(retrofitService)
    }

}