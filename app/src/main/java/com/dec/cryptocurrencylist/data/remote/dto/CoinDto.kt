package com.dec.cryptocurrencylist.data.remote.dto

import com.dec.cryptocurrencylist.domain.model.Coin
import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object class for Coins. This file contains
 * all data which are coming from API. We might not need
 * all those data. So we narrow it down in model pkg:Coin.kt
 *
 * We need to transform CoinDto to Coin. This is done using a fun
 * in below code.
 */
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

/**
 * This fun helps to transform CoinDto to Coin
 */
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
