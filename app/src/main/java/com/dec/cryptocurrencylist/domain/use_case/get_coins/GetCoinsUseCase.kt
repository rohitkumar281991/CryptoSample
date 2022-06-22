package com.dec.cryptocurrencylist.domain.use_case.get_coins

import com.dec.cryptocurrencylist.common.Resource
import com.dec.cryptocurrencylist.data.remote.dto.toCoin
import com.dec.cryptocurrencylist.domain.model.Coin
import com.dec.cryptocurrencylist.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Use case class will have only one work to do. Here its only task is to get coins.
 */
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage
                        ?: "Couldn't reach server. Please check you internet connection"
                )
            )
        }
    }
}