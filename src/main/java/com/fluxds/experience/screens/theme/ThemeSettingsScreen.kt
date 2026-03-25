package com.fluxds.experience.screens.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.ColorSchemePreference
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.theme.FluxDarkBrandTheme
import com.fluxds.ds.theme.FluxDefaultTheme
import com.fluxds.ds.theme.FluxThemeConfig
import com.fluxds.ds.theme.FluxThemeState
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonVariant
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxSegmentedControl

@Composable
fun ThemeSettingsScreen(themeState: FluxThemeState) {
    val colors = FluxColors.current

    val colorSchemeOptions = listOf("System", "Light", "Dark")
    var colorSchemeIndex by remember {
        mutableIntStateOf(
            when (themeState.colorSchemePreference) {
                ColorSchemePreference.System -> 0
                ColorSchemePreference.Light -> 1
                ColorSchemePreference.Dark -> 2
            }
        )
    }

    val brandOptions = listOf("Default", "Dark Brand")
    var brandIndex by remember {
        mutableIntStateOf(
            if (themeState.themeConfig.light == FluxDefaultTheme.light) 0 else 1
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Theme Settings",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )

        // --- Color Scheme Picker ---
        Text(
            text = "Color Scheme",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = colorSchemeOptions,
            selectedIndex = colorSchemeIndex,
            onSelectionChanged = { index ->
                colorSchemeIndex = index
                themeState.colorSchemePreference = when (index) {
                    0 -> ColorSchemePreference.System
                    1 -> ColorSchemePreference.Light
                    2 -> ColorSchemePreference.Dark
                    else -> ColorSchemePreference.System
                }
            }
        )

        FluxDivider()

        // --- Brand Picker ---
        Text(
            text = "Brand",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = brandOptions,
            selectedIndex = brandIndex,
            onSelectionChanged = { index ->
                brandIndex = index
                themeState.themeConfig = when (index) {
                    0 -> FluxThemeConfig(
                        light = FluxDefaultTheme.light,
                        dark = FluxDefaultTheme.dark
                    )
                    1 -> FluxThemeConfig(
                        light = FluxDarkBrandTheme.colors,
                        dark = FluxDarkBrandTheme.colors
                    )
                    else -> FluxThemeConfig()
                }
            }
        )

        FluxDivider()

        // --- Live Color Swatches ---
        Text(
            text = "Live Color Swatches",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        val swatchColors = listOf(
            "Primary" to colors.primary,
            "Secondary" to colors.secondary,
            "Accent" to colors.accent,
            "Success" to colors.success,
            "Warning" to colors.warning,
            "Error" to colors.error
        )

        // Grid: 3 columns x 2 rows
        for (rowIndex in swatchColors.indices step 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
            ) {
                for (colIndex in 0 until 3) {
                    val index = rowIndex + colIndex
                    if (index < swatchColors.size) {
                        val (label, color) = swatchColors[index]
                        ColorSwatchBox(
                            label = label,
                            color = color,
                            textColor = colors.textPrimary,
                            borderColor = colors.border,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        FluxDivider()

        // --- Button Preview ---
        Text(
            text = "Button Preview",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxButton(
            title = "Primary Button",
            variant = FluxButtonVariant.Primary,
            onClick = {}
        )

        FluxButton(
            title = "Secondary Button",
            variant = FluxButtonVariant.Secondary,
            onClick = {}
        )

        FluxButton(
            title = "Destructive Button",
            variant = FluxButtonVariant.Destructive,
            onClick = {}
        )
    }
}

@Composable
private fun ColorSwatchBox(
    label: String,
    color: Color,
    textColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.xs)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(FluxRadius.sm))
                .background(color)
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(FluxRadius.sm)
                )
        )

        Text(
            text = label,
            style = FluxTypography.caption,
            color = textColor
        )
    }
}
