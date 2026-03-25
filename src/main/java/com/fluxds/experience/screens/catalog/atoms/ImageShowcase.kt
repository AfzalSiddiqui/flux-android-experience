package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxImage
import com.fluxds.foundation.atoms.FluxImageSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ImageShowcase() {
    val colors = FluxColors.current
    val sampleUrl = "https://picsum.photos/200"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Image",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Sizes ---
        Text(
            text = "Sizes",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Small,
                    contentDescription = "Small image"
                )
                Text(text = "Small (40dp)", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    contentDescription = "Medium image"
                )
                Text(text = "Medium (80dp)", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Large,
                    contentDescription = "Large image"
                )
                Text(text = "Large (160dp)", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        // --- Corner Radius ---
        Text(
            text = "Corner Radius Variations",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    cornerRadius = 0.dp,
                    contentDescription = "No radius"
                )
                Text(text = "None", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    cornerRadius = FluxRadius.sm,
                    contentDescription = "Small radius"
                )
                Text(text = "Small", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    cornerRadius = FluxRadius.md,
                    contentDescription = "Medium radius"
                )
                Text(text = "Medium", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    cornerRadius = FluxRadius.full,
                    contentDescription = "Full radius"
                )
                Text(text = "Full (Circle)", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        // --- With Border ---
        Text(
            text = "With Border",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    borderColor = colors.primary,
                    contentDescription = "Primary border"
                )
                Text(text = "Primary", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxImage(
                    source = sampleUrl,
                    size = FluxImageSize.Medium,
                    borderColor = colors.error,
                    contentDescription = "Error border"
                )
                Text(text = "Error", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        // --- Null Source (placeholder) ---
        Text(
            text = "Null Source (Placeholder)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxImage(
            source = null,
            size = FluxImageSize.Medium,
            contentDescription = "Null source placeholder"
        )
    }
}
