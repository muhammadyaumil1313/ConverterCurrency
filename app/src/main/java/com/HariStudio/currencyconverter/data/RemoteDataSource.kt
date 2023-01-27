package com.HariStudio.currencyconverter.data

import com.HariStudio.currencyconverter.models.ConvertCurrency
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val currencyRatesApi: CurrencyRatesApi ) {
    suspend fun getExchangeRates(queries: Map<String, String>) : Response<ConvertCurrency>{
         return currencyRatesApi.getExchangeRates(queries)

    }
}