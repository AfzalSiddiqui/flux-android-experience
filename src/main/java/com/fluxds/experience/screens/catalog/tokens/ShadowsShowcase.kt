package com.fluxds.experience.screens.catalog.tokens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxShadow
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography

/**
 * Showcase screen displaying the 3 shadow elevation presets from the Flux Design System.
 */
@Composable
fun ShadowsShowcase() {
    val colors = FluxColors.current

    val shadowEntries = listOf(
        "small" to FluxShadow.small,
        "medium" to FluxShadow.medium,
        "large" to FluxShadow.large
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "Shadows",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(bottom = FluxSpacing.md)
        )

        Text(
            text = "3 shadow elevation presets from FluxShadow.",
            style = FluxTypography.body,
            color = colors.textSecondary,
            modifier = Modifier.padding(bottom = FluxSpacing.lg)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = FluxSpacing.md),
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md)
        ) {
            shadowEntries.forEach { (name, config) ->
                ShadowItem(
                    name = name,
                    config = config,
                    modifier = Modifier.weight(1f),
                    surfaceColor = colors.surface,
                    textColor = colors.textPrimary,
                    secondaryTextColor = colors.textSecondary
                )
            }
        }

        // Detailed breakdown below
        Text(
            text = "Details",
            style = FluxTypography.title3,
            color = colors.textPrimary,
            modifier = Modifier.padding(top = FluxSpacing.lg, bottom = FluxSpacing.sm)
        )

        shadowEntries.forEach { (name, config) ->
            ShadowDetailItem(
                name = name,
                config = config,
                textColor = colors.textPrimary,
                secondaryTextColor = colors.textSecondary
            )
        }
    }
}

@Composable
private fun ShadowItem(
    name: String,
    config: FluxShadow.ShadowConfig,
    modifier: Modifier = Modifier,
    surfaceColor: androidx.compose.ui.graphics.Color,
    textColor: androidx.compose.ui.graphics.Color,
    secondaryTextColor: androidx.compose.ui.graphics.Color
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(FluxRadius.md),
            color = surfaceColor,
            shadowElevation = config.elevation
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = name,
                    style = FluxTypography.headline,
                    color = textColor
                )
            }
        }
        Text(
            text = "elevation: ${config.elevation}",
            style = FluxTypography.caption,
            color = secondaryTextColor,
            modifier = Modifier.padding(top = FluxSpacing.xs)
        )
    }
}

@Composable
private fun ShadowDetailItem(
    name: String,
    config: FluxShadow.ShadowConfig,
    textColor: androidx.compose.ui.graphics.Color,
    secondaryTextColor: androidx.compose.ui.graphics.Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = FluxSpacing.xs)
    ) {
        Text(
            text = "FluxShadow.$name",
            style = FluxTypography.headline,
            color = textColor
        )
        Text(
            text = "elevation: ${config.elevation} | blur: ${config.blurRadius} | offsetY: ${config.offsetY} | opacity: ${config.opacity}",
            style = FluxTypography.caption,
            color = secondaryTextColor
        )
    }
}
