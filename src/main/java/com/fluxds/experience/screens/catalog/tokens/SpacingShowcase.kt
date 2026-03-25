package com.fluxds.experience.screens.catalog.tokens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography

/**
 * Showcase screen displaying all 8 spacing values from the Flux Design System.
 */
@Composable
fun SpacingShowcase() {
    val colors = FluxColors.current

    val spacingEntries = listOf(
        "xxxs" to FluxSpacing.xxxs,
        "xxs" to FluxSpacing.xxs,
        "xs" to FluxSpacing.xs,
        "sm" to FluxSpacing.sm,
        "md" to FluxSpacing.md,
        "lg" to FluxSpacing.lg,
        "xl" to FluxSpacing.xl,
        "xxl" to FluxSpacing.xxl
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "Spacing",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(bottom = FluxSpacing.md)
        )

        Text(
            text = "All 8 spacing values from FluxSpacing (4pt grid).",
            style = FluxTypography.body,
            color = colors.textSecondary,
            modifier = Modifier.padding(bottom = FluxSpacing.lg)
        )

        spacingEntries.forEach { (name, value) ->
            SpacingItem(
                name = name,
                value = value,
                textColor = colors.textPrimary,
                secondaryTextColor = colors.textSecondary,
                barColor = colors.primary
            )
        }
    }
}

@Composable
private fun SpacingItem(
    name: String,
    value: Dp,
    textColor: androidx.compose.ui.graphics.Color,
    secondaryTextColor: androidx.compose.ui.graphics.Color,
    barColor: androidx.compose.ui.graphics.Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = FluxSpacing.xs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
    ) {
        Text(
            text = name,
            style = FluxTypography.headline,
            color = textColor,
            modifier = Modifier.width(FluxSpacing.xxl)
        )

        Text(
            text = "${value.value.toInt()}dp",
            style = FluxTypography.caption,
            color = secondaryTextColor,
            modifier = Modifier.width(FluxSpacing.xl)
        )

        Box(
            modifier = Modifier
                .width(value * 4)
                .height(FluxSpacing.md)
                .clip(RoundedCornerShape(FluxRadius.xs))
                .background(barColor)
        )
    }
}
