package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxIcon
import com.fluxds.foundation.atoms.FluxIconSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IconShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Icon",
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
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.lg),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Star,
                    size = FluxIconSize.Small
                )
                Text(text = "Small", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Star,
                    size = FluxIconSize.Medium
                )
                Text(text = "Medium", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Star,
                    size = FluxIconSize.Large
                )
                Text(text = "Large", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        // --- Various Icons ---
        Text(
            text = "Material Icons",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            FluxIcon(imageVector = Icons.Filled.Home, contentDescription = "Home")
            FluxIcon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            FluxIcon(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
            FluxIcon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
            FluxIcon(imageVector = Icons.Filled.Check, contentDescription = "Check")
            FluxIcon(imageVector = Icons.Filled.Close, contentDescription = "Close")
            FluxIcon(imageVector = Icons.Filled.Info, contentDescription = "Info")
            FluxIcon(imageVector = Icons.Filled.Warning, contentDescription = "Warning")
        }

        // --- Colors ---
        Text(
            text = "Custom Colors",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Favorite,
                    size = FluxIconSize.Large,
                    color = colors.primary
                )
                Text(text = "Primary", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Favorite,
                    size = FluxIconSize.Large,
                    color = colors.error
                )
                Text(text = "Error", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Favorite,
                    size = FluxIconSize.Large,
                    color = colors.success
                )
                Text(text = "Success", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Favorite,
                    size = FluxIconSize.Large,
                    color = colors.warning
                )
                Text(text = "Warning", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxIcon(
                    imageVector = Icons.Filled.Favorite,
                    size = FluxIconSize.Large,
                    color = Color(0xFF9C27B0)
                )
                Text(text = "Custom", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }
    }
}
