package com.dec.cryptocurrencylist.domain.use_case.get_coin

import com.dec.cryptocurrencylist.common.Resource
import com.dec.cryptocurrencylist.data.remote.dto.toCoinDetail
import com.dec.cryptocurrencylist.domain.model.CoinDetail
import com.dec.cryptocurrencylist.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Use case class will have only one work to do. Here its only task is to get coins.
 */
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage
                        ?: "Couldn't reach server. Please check you internet connection"
                )
            )
        } catch (e: NullPointerException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage
                        ?: "Data is null"
                )
            )
        }
    }
}