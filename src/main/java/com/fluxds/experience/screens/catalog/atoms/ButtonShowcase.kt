package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonSize
import com.fluxds.foundation.atoms.FluxButtonVariant

@Composable
fun ButtonShowcase() {
    val colors = FluxColors.current
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Button",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Variants ---
        Text(
            text = "Variants",
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

        // --- Sizes ---
        Text(
            text = "Sizes",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxButton(
            title = "Small",
            size = FluxButtonSize.Small,
            onClick = {}
        )

        FluxButton(
            title = "Medium",
            size = FluxButtonSize.Medium,
            onClick = {}
        )

        FluxButton(
            title = "Large",
            size = FluxButtonSize.Large,
            onClick = {}
        )

        // --- Loading State ---
        Text(
            text = "Loading State",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxButton(
            title = "Toggle Loading",
            variant = FluxButtonVariant.Secondary,
            onClick = { isLoading = !isLoading }
        )

        FluxButton(
            title = "Loading Button",
            isLoading = isLoading,
            onClick = {}
        )

        FluxButton(
            title = "Loading Secondary",
            variant = FluxButtonVariant.Secondary,
            isLoading = isLoading,
            onClick = {}
        )

        FluxButton(
            title = "Loading Destructive",
            variant = FluxButtonVariant.Destructive,
            isLoading = isLoading,
            onClick = {}
        )

        // --- Disabled State ---
        Text(
            text = "Disabled State",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxButton(
            title = "Disabled Primary",
            isDisabled = true,
            onClick = {}
        )

        FluxButton(
            title = "Disabled Secondary",
            variant = FluxButtonVariant.Secondary,
            isDisabled = true,
            onClick = {}
        )

        FluxButton(
            title = "Disabled Destructive",
            variant = FluxButtonVariant.Destructive,
            isDisabled = true,
            onClick = {}
        )
    }
}
