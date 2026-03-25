package com.fluxds.experience.screens.catalog.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxShadow
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxCard

@Composable
fun CardShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "Card",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Card with small shadow and default padding
        Text(
            text = "Small Shadow (default)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxCard(
            modifier = Modifier.fillMaxWidth(),
            padding = FluxSpacing.md,
            cornerRadius = FluxRadius.md,
            shadowConfig = FluxShadow.small
        ) {
            Column {
                Text(
                    text = "Default Card",
                    style = FluxTypography.headline,
                    color = colors.textPrimary
                )
                Text(
                    text = "Padding: md, Corner Radius: md, Shadow: small",
                    style = FluxTypography.footnote,
                    color = colors.textSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Card with medium shadow and larger padding
        Text(
            text = "Medium Shadow, Large Padding",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxCard(
            modifier = Modifier.fillMaxWidth(),
            padding = FluxSpacing.lg,
            cornerRadius = FluxRadius.lg,
            shadowConfig = FluxShadow.medium
        ) {
            Column {
                Text(
                    text = "Elevated Card",
                    style = FluxTypography.headline,
                    color = colors.textPrimary
                )
                Text(
                    text = "Padding: lg, Corner Radius: lg, Shadow: medium",
                    style = FluxTypography.footnote,
                    color = colors.textSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Card with large shadow and extra-large corner radius
        Text(
            text = "Large Shadow, XL Radius",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxCard(
            modifier = Modifier.fillMaxWidth(),
            padding = FluxSpacing.xl,
            cornerRadius = FluxRadius.xl,
            shadowConfig = FluxShadow.large
        ) {
            Column {
                Text(
                    text = "Prominent Card",
                    style = FluxTypography.headline,
                    color = colors.textPrimary
                )
                Text(
                    text = "Padding: xl, Corner Radius: xl, Shadow: large",
                    style = FluxTypography.footnote,
                    color = colors.textSecondary
                )
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(
                    text = "This card uses the largest shadow elevation for a prominent, floating appearance.",
                    style = FluxTypography.body,
                    color = colors.textPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
