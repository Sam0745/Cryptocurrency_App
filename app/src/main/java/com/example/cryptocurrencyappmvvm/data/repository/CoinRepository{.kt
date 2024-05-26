package com.example.cryptocurrencyappmvvm.data.repository

import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDto

interface CoinRepository{
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinBy(coinId:String):CoinDetailDto
}