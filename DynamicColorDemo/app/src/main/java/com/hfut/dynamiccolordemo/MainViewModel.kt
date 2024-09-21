package com.hfut.dynamiccolordemo

import android.app.Application
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hfut.dynamiccolordemo.PrefHelper.get
import com.hfut.dynamiccolordemo.PrefHelper.operation
import com.hfut.dynamiccolordemo.PrefHelper.put
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

val DEFAULT_THEME = CatalogTheme.RED_THEME.name

enum class CatalogTheme(val paletteName: String, val lightColorScheme: ColorScheme, val darkColorScheme: ColorScheme) {
    RED_THEME("RED", RedLightColors, RedDarkColors),
   // TEAL_THEME("TEAL", TealLightColors, TealDarkColors),
   // BLUE_THEME("BLUE", BlueLightColors, BlueDarkColors),
    //DEEP_ORANGE_THEME("ORANGE", DeepOrangeLightColors, DeepOrangeDarkColors),
    //GREEN_THEME("GREEN", GreenLightColors, GreenDarkColors)
}


@HiltViewModel
class MainViewModel  @Inject constructor(private val app: Application) : ViewModel() {

    val currentTheme = mutableStateOf(
        PrefHelper.prefs(app.applicationContext)
            .get(PrefHelper.KEY_CURRENT_THEME, DEFAULT_THEME) as String
    )

    fun setCurrentTheme(theme: String) {
        currentTheme.value = theme
        PrefHelper.prefs(app.applicationContext).operation {
            it.put(Pair(PrefHelper.KEY_CURRENT_THEME, theme))
        }
    }
}