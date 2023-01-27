package com.HariStudio.currencyconverter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.HariStudio.currencyconverter.R

private val DarkColorPalette = darkColors(
    primary = Orange_700,
    primaryVariant = Orange_700,
    onPrimary = White_900
)

private val LightColorPalette = lightColors(
    primary = Orange_700,
    primaryVariant = Orange_700,
    onPrimary = White_900

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
val lato = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal)
)
val poppins = FontFamily(
    Font(R.font.poppins_regular,FontWeight.Normal)
)
val lightThemeTypography = Typography(
    body1 = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Value_Color
    )
)
val darkThemeTypography = Typography(
    body1 = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = White_900
    )
)

@Composable
fun CurrencyConverterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val typography = if(darkTheme){
        darkThemeTypography
    }else{
        lightThemeTypography
    }
    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}