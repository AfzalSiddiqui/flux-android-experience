package com.fluxds.experience.screens.catalog.tokens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxBorder
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography

/**
 * Showcase screen displaying all 6 corner radius presets from the Flux Design System.
 */
@Composable
fun RadiusShowcase() {
    val colors = FluxColors.current

    val radiusEntries = listOf(
        "xs" to FluxRadius.xs,
        "sm" to FluxRadius.sm,
        "md" to FluxRadius.md,
        "lg" to FluxRadius.lg,
        "xl" to FluxRadius.xl,
        "full" to FluxRadius.full
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "Radius",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(bottom = FluxSpacing.md)
        )

        Text(
            text = "All 6 corner radius presets from FluxRadius.",
            style = FluxTypography.body,
            color = colors.textSecondary,
            modifier = Modifier.padding(bottom = FluxSpacing.lg)
        )

        radiusEntries.forEach { (name, radius) ->
            RadiusItem(
                name = name,
                radius = radius,
                surfaceColor = colors.surface,
                borderColor = colors.border,
                textColor = colors.textPrimary,
                secondaryTextColor = colors.textSecondary
            )
        }
    }
}

@Composable
private fun RadiusItem(
    name: String,
    radius: Dp,
    surfaceColor: androidx.compose.ui.graphics.Color,
    borderColor: androidx.compose.ui.graphics.Color,
    textColor: androidx.compose.ui.graphics.Color,
    secondaryTextColor: androidx.compose.ui.graphics.Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = FluxSpacing.xs)
    ) {
        Text(
            text = name,
            style = FluxTypography.headline,
            color = textColor
        )
        Text(
            text = if (radius == FluxRadius.full) "full (9999dp)" else "${radius.value.toInt()}dp",
            style = FluxTypography.caption,
            color = secondaryTextColor,
            modifier = Modifier.padding(bottom = FluxSpacing.xs)
        )

        val shape = RoundedCornerShape(radius)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(shape)
                .background(surfaceColor)
                .border(
                    width = FluxBorder.medium,
                    color = borderColor,
                    shape = shape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "FluxRadius.$name",
                style = FluxTypography.callout,
                color = textColor
            )
        }
    }
}
