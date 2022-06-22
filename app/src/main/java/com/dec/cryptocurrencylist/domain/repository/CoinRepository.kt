package com.dec.cryptocurrencylist.domain.repository

import com.dec.cryptocurrencylist.data.remote.dto.CoinDetailDto
import com.dec.cryptocurrencylist.data.remote.dto.CoinDto

/**
 * There is difference b/w this repository and repository in data pkg. This class helps
 * while testing. This class is not directly interacting with actual repository code.
 * So while testing we can attach fake repository and implement these two fun to simulate
 * behaviour.
 */
interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}