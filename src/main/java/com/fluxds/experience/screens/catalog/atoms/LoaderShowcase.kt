package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxLoader
import com.fluxds.foundation.atoms.FluxLoaderSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LoaderShowcase() {
    val colors = FluxColors.current
    var progressValue by remember { mutableFloatStateOf(0.5f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Loader",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Spinner Sizes ---
        Text(
            text = "Spinner Sizes",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.xl),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxLoader(size = FluxLoaderSize.Small)
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(text = "Small", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxLoader(size = FluxLoaderSize.Medium)
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(text = "Medium", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxLoader(size = FluxLoaderSize.Large)
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(text = "Large", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        // --- Custom Tint ---
        Text(
            text = "Custom Tint Colors",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.xl),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxLoader(size = FluxLoaderSize.Medium, tint = colors.primary)
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(text = "Primary", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxLoader(size = FluxLoaderSize.Medium, tint = colors.error)
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(text = "Error", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxLoader(size = FluxLoaderSize.Medium, tint = colors.success)
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(text = "Success", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        // --- Progress Bar ---
        Text(
            text = "Progress Bar",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        Text(
            text = "Progress: ${(progressValue * 100).toInt()}%",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )

        FluxLoader(
            progress = progressValue,
            modifier = Modifier.fillMaxWidth()
        )

        Slider(
            value = progressValue,
            onValueChange = { progressValue = it },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth()
        )

        // --- Progress Bar with Custom Tint ---
        Text(
            text = "Progress Bar - Custom Colors",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxLoader(
            progress = 0.3f,
            tint = colors.error,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Error tint (30%)", style = FluxTypography.caption, color = colors.textSecondary)

        FluxLoader(
            progress = 0.7f,
            tint = colors.success,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Success tint (70%)", style = FluxTypography.caption, color = colors.textSecondary)

        FluxLoader(
            progress = 1.0f,
            tint = colors.warning,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Warning tint (100%)", style = FluxTypography.caption, color = colors.textSecondary)
    }
}
