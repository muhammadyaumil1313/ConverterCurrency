package com.HariStudio.currencyconverter.models


import com.google.gson.annotations.SerializedName

data class ConvertCurrency(
    @SerializedName("base")
    val base: String, // EUR
    @SerializedName("date")
    val date: String, // 2023-01-27
    @SerializedName("rates")
    val rates: Rates,
    @SerializedName("success")
    val success: Boolean // true
)