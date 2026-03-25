package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxBorder
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxDividerAxis

@Composable
fun DividerShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Divider",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Horizontal Dividers ---
        Text(
            text = "Horizontal (Default)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxDivider()

        // --- Thickness Variations ---
        Text(
            text = "Thickness Variations",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        Text(text = "Thin (${FluxBorder.thin})", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(thickness = FluxBorder.thin)

        Text(text = "Medium (${FluxBorder.medium})", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(thickness = FluxBorder.medium)

        Text(text = "Thick (${FluxBorder.thick})", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(thickness = FluxBorder.thick)

        Text(text = "Custom (4dp)", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(thickness = 4.dp)

        // --- Color Variations ---
        Text(
            text = "Color Variations",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        Text(text = "Default (divider)", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider()

        Text(text = "Primary", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(color = colors.primary, thickness = FluxBorder.thick)

        Text(text = "Error", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(color = colors.error, thickness = FluxBorder.thick)

        Text(text = "Success", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(color = colors.success, thickness = FluxBorder.thick)

        Text(text = "Warning", style = FluxTypography.caption, color = colors.textSecondary)
        FluxDivider(color = colors.warning, thickness = FluxBorder.thick)

        // --- Vertical Dividers ---
        Text(
            text = "Vertical Dividers",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Left", style = FluxTypography.body, color = colors.textPrimary)
            FluxDivider(axis = FluxDividerAxis.Vertical)
            Text(text = "Center", style = FluxTypography.body, color = colors.textPrimary)
            FluxDivider(axis = FluxDividerAxis.Vertical, color = colors.primary, thickness = FluxBorder.thick)
            Text(text = "Right", style = FluxTypography.body, color = colors.textPrimary)
        }

        // --- With Corner Radius ---
        Text(
            text = "With Corner Radius",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxDivider(thickness = 4.dp, cornerRadius = 2.dp, color = colors.primary)
        FluxDivider(thickness = 6.dp, cornerRadius = 3.dp, color = colors.accent)
    }
}
