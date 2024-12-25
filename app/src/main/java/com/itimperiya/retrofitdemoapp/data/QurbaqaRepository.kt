package com.itimperiya.retrofitdemoapp.data

import com.itimperiya.retrofitdemoapp.network.Qurbaqa
import com.itimperiya.retrofitdemoapp.network.QurbaqaApiService

interface QurbaqaRepository {
    suspend fun getQurbaqalar(): List<Qurbaqa>
}

class NetworkQurbaqaRepository(private val qurbaqaApiService: QurbaqaApiService): QurbaqaRepository {

    override suspend fun getQurbaqalar(): List<Qurbaqa> = qurbaqaApiService.getQurbaqalar()

}