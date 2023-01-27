package com.HariStudio.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.HariStudio.currencyconverter.composable.ConverterScreen
import com.HariStudio.currencyconverter.ui.theme.CurrencyConverterTheme
import com.HariStudio.currencyconverter.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme{
                mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
                ConverterScreen(this,mainViewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    lateinit var mainViewModel: MainViewModel
    CurrencyConverterTheme {
        val context = LocalContext.current
        mainViewModel = ViewModelProvider(context as ViewModelStoreOwner)[MainViewModel::class.java]
        ConverterScreen(context,mainViewModel)
    }
}