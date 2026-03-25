package com.fluxds.experience

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.fluxds.ds.theme.FluxTheme
import com.fluxds.ds.theme.FluxThemeState
import com.fluxds.experience.navigation.FluxExperienceApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeState = remember { FluxThemeState() }
            FluxTheme(state = themeState) {
                FluxExperienceApp(themeState = themeState)
            }
        }
    }
}
