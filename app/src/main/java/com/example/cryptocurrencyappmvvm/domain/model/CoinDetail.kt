package com.example.cryptocurrencyappmvvm.domain.model

import android.hardware.biometrics.BiometricManager
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyappmvvm.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol:String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)

fun CoinDetailDto.toCoinDetail():CoinDetail{
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        isActive = is_active,
        rank = rank,
        tags = tags.map { it.name },
        team = team
    )
}