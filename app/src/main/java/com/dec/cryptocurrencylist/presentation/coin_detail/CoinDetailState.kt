package com.dec.cryptocurrencylist.presentation.coin_detail

import com.dec.cryptocurrencylist.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
