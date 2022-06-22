package com.dec.cryptocurrencylist.domain.model

/**
 * This is not in direct touch with API calls, so removed
 * serializedName annotation.
 * It will be used to display specific coin data in the list
 * This class should be used while showing in UI.
 */
data class Coin(
    val id:String,
    val isActive:Boolean,
    val name:String,
    val rank:Int,
    val symbol:String,
)
