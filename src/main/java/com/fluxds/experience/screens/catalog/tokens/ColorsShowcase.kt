package com.fluxds.experience.screens.catalog.tokens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography

/**
 * Showcase screen displaying all 16 semantic color tokens from the Flux Design System.
 */
@Composable
fun ColorsShowcase() {
    val colors = FluxColors.current

    val colorEntries = listOf(
        "primary" to colors.primary,
        "secondary" to colors.secondary,
        "accent" to colors.accent,
        "background" to colors.background,
        "surface" to colors.surface,
        "textPrimary" to colors.textPrimary,
        "textSecondary" to colors.textSecondary,
        "success" to colors.success,
        "warning" to colors.warning,
        "error" to colors.error,
        "border" to colors.border,
        "divider" to colors.divider,
        "onPrimary" to colors.onPrimary,
        "onSecondary" to colors.onSecondary,
        "onError" to colors.onError,
        "overlay" to colors.overlay
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "Colors",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(bottom = FluxSpacing.md)
        )

        Text(
            text = "All 16 semantic color tokens from FluxColors.",
            style = FluxTypography.body,
            color = colors.textSecondary,
            modifier = Modifier.padding(bottom = FluxSpacing.lg)
        )

        colorEntries.forEach { (name, color) ->
            ColorSwatchRow(
                name = name,
                color = color,
                textColor = colors.textPrimary,
                secondaryTextColor = colors.textSecondary,
                borderColor = colors.border
            )
        }
    }
}

@Composable
private fun ColorSwatchRow(
    name: String,
    color: Color,
    textColor: Color,
    secondaryTextColor: Color,
    borderColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = FluxSpacing.xs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(FluxRadius.sm))
                .background(color)
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(FluxRadius.sm)
                )
        )

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                style = FluxTypography.headline,
                color = textColor
            )
            Text(
                text = colorToHexString(color),
                style = FluxTypography.caption,
                color = secondaryTextColor
            )
        }
    }
}

/**
 * Converts a Compose Color to a hex string representation.
 */
private fun colorToHexString(color: Color): String {
    val argb = color.toArgb()
    val alpha = (argb shr 24) and 0xFF
    val red = (argb shr 16) and 0xFF
    val green = (argb shr 8) and 0xFF
    val blue = argb and 0xFF
    return if (alpha < 255) {
        String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
    } else {
        String.format("#%02X%02X%02X", red, green, blue)
    }
}
