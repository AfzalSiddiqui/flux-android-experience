package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxToggle

@Composable
fun ToggleShowcase() {
    val colors = FluxColors.current

    var toggle1 by remember { mutableStateOf(true) }
    var toggle2 by remember { mutableStateOf(false) }
    var toggle3 by remember { mutableStateOf(true) }
    var toggle4 by remember { mutableStateOf(false) }
    var toggle5 by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Toggle",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- With Labels ---
        Text(
            text = "With Labels",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxToggle(
            isOn = toggle1,
            label = "Enable notifications",
            modifier = Modifier.fillMaxWidth(),
            onToggle = { toggle1 = it }
        )

        FluxToggle(
            isOn = toggle2,
            label = "Dark mode",
            modifier = Modifier.fillMaxWidth(),
            onToggle = { toggle2 = it }
        )

        FluxToggle(
            isOn = toggle3,
            label = "Auto-sync",
            modifier = Modifier.fillMaxWidth(),
            onToggle = { toggle3 = it }
        )

        FluxDivider()

        // --- Without Label ---
        Text(
            text = "Without Label",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxToggle(
            isOn = toggle4,
            onToggle = { toggle4 = it }
        )

        FluxDivider()

        // --- Custom Tint Colors ---
        Text(
            text = "Custom Tint Colors",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxToggle(
            isOn = true,
            label = "Primary (default)",
            tintColor = colors.primary,
            modifier = Modifier.fillMaxWidth(),
            onToggle = {}
        )

        FluxToggle(
            isOn = true,
            label = "Error tint",
            tintColor = colors.error,
            modifier = Modifier.fillMaxWidth(),
            onToggle = {}
        )

        FluxToggle(
            isOn = true,
            label = "Success tint",
            tintColor = colors.success,
            modifier = Modifier.fillMaxWidth(),
            onToggle = {}
        )

        FluxToggle(
            isOn = true,
            label = "Warning tint",
            tintColor = colors.warning,
            modifier = Modifier.fillMaxWidth(),
            onToggle = {}
        )

        FluxDivider()

        // --- Disabled State ---
        Text(
            text = "Disabled State",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxToggle(
            isOn = true,
            label = "Disabled (On)",
            isDisabled = true,
            modifier = Modifier.fillMaxWidth(),
            onToggle = {}
        )

        FluxToggle(
            isOn = false,
            label = "Disabled (Off)",
            isDisabled = true,
            modifier = Modifier.fillMaxWidth(),
            onToggle = {}
        )

        FluxDivider()

        // --- Interactive Demo ---
        Text(
            text = "Interactive Demo",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxToggle(
            isOn = toggle5,
            label = if (toggle5) "Feature is ON" else "Feature is OFF",
            modifier = Modifier.fillMaxWidth(),
            onToggle = { toggle5 = it }
        )

        Text(
            text = "Current state: ${if (toggle5) "Enabled" else "Disabled"}",
            style = FluxTypography.footnote,
            color = if (toggle5) colors.success else colors.textSecondary
        )
    }
}
