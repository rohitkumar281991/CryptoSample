package com.dec.cryptocurrencylist.data.repository

import com.dec.cryptocurrencylist.data.remote.CoinPaprikaApi
import com.dec.cryptocurrencylist.data.remote.dto.CoinDetailDto
import com.dec.cryptocurrencylist.data.remote.dto.CoinDto
import com.dec.cryptocurrencylist.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * This class does actual interaction with APIs.
 */
class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}