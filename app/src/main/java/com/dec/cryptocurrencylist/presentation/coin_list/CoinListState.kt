package com.dec.cryptocurrencylist.presentation.coin_list

import com.dec.cryptocurrencylist.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
