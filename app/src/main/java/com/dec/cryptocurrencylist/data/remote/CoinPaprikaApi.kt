package com.dec.cryptocurrencylist.data.remote

import com.dec.cryptocurrencylist.data.remote.dto.CoinDetailDto
import com.dec.cryptocurrencylist.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit api calls happen from here
 */
interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}