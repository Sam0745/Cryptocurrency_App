package com.example.cryptocurrencyappmvvm.domain.use_case.get_coin

import com.example.cryptocurrencyappmvvm.comman.Resource
import com.example.cryptocurrencyappmvvm.data.repository.CoinRepository
import com.example.cryptocurrencyappmvvm.domain.model.CoinDetail
import com.example.cryptocurrencyappmvvm.domain.model.toCoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinBy(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, check your internet connection"))
        }
    }
}