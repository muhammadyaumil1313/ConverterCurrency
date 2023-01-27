package com.HariStudio.currencyconverter.utils

import com.HariStudio.currencyconverter.models.CurrencyAndCountry

class Constants {
    companion object{
        val APP_BAR_TITLE = "Currency\nConverter"
        val BASE_URL = "https://api.exchangerate.host/"
        val CURRENCY_CODE_LIST = listOf(
            CurrencyAndCountry(countryName = "Indonesia", currencyCode = "IDR"),
            CurrencyAndCountry(countryName = "Malaysia", currencyCode = "RM"),
            CurrencyAndCountry(countryName = "United State of America", currencyCode = "USD"),
            CurrencyAndCountry(countryName = "Singapore", currencyCode = "SGD")
        )
    }
}