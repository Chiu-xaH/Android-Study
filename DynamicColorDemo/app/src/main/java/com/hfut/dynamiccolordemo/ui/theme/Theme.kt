package com.hfut.dynamiccolordemo.ui.theme

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

import com.hfut.dynamiccolordemo.CatalogTheme
import com.hfut.dynamiccolordemo.DEFAULT_THEME

import com.hfut.dynamiccolordemo.PrefHelper
import com.hfut.dynamiccolordemo.RedDarkColors
import com.hfut.dynamiccolordemo.RedLightColors


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun DynamicColorDemoTheme(
    context: Context,
    currentTheme: String? = PrefHelper.prefs(context).getString(PrefHelper.KEY_CURRENT_THEME, DEFAULT_THEME),
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colorScheme = if(dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }else{
        when(currentTheme){
            CatalogTheme.RED_THEME.name->{ if(darkTheme) RedDarkColors else RedLightColors }
           // CatalogTheme.TEAL_THEME.name->{ if(darkTheme) TealDarkColors else TealLightColors }
           // CatalogTheme.BLUE_THEME.name->{ if(darkTheme) BlueDarkColors else BlueLightColors }
          //  CatalogTheme.DEEP_ORANGE_THEME.name->{ if(darkTheme) DeepOrangeDarkColors else DeepOrangeLightColors}
           // CatalogTheme.GREEN_THEME.name-> { if(darkTheme) GreenDarkColors else GreenLightColors}
            else->{ if(darkTheme) RedDarkColors else RedLightColors }
        }
    }
    /*    val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
                ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
            }
        }*/

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}