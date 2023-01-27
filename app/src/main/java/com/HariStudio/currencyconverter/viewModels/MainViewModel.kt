package com.HariStudio.currencyconverter.viewModels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.HariStudio.currencyconverter.data.Repositories
import com.HariStudio.currencyconverter.models.ConvertCurrency
import com.HariStudio.currencyconverter.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository : Repositories, application: Application)
    : AndroidViewModel(application) {
        var exchangeRatesResponse : MutableLiveData<NetworkResult<ConvertCurrency>> = MutableLiveData()
    fun getExchangeRates(queries: Map<String, String>){
        viewModelScope.launch {
            getExchangeRatesSafeCall(queries)
        }
    }

    private suspend fun getExchangeRatesSafeCall(queries: Map<String, String>) {
        if (checkInternetConnection()){
            try {
                val response = repository.remote.getExchangeRates(queries)
                exchangeRatesResponse.value = handleExchangeRatesResponse(response)
            }catch (e : java.lang.Exception){
                exchangeRatesResponse.value = NetworkResult.Error(message = "No Response")
                Log.e("Error Response : " , "Error : $e")
            }
        }else{
            exchangeRatesResponse.value = NetworkResult.Error(message = "No Internet Connection")
        }
    }

    private fun handleExchangeRatesResponse(response: Response<ConvertCurrency>): NetworkResult<ConvertCurrency>? {
        return when{
            response.message().toString().contains("timeout")->{
                NetworkResult.Error(message = "Timeout")
            }
            response.isSuccessful -> {
                val exchangeResponse = response.body()
                NetworkResult.Success(data = exchangeResponse!!)
            }
            else->{
                NetworkResult.Error(message = "Could Not Fetch Result")
            }
        }
    }

    private fun checkInternetConnection() : Boolean{
        val connectionManager =getApplication<Application>()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectionManager.activeNetwork ?: return false
        val capabilities = connectionManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)->true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)->true
            else->false
        }
    }
}