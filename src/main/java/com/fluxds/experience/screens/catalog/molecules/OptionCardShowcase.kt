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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxOptionCard
import com.fluxds.foundation.molecules.FluxOptionItem
import com.fluxds.foundation.molecules.FluxSelectionMode

@Composable
fun OptionCardShowcase() {
    val colors = FluxColors.current

    var singleSelection by remember { mutableStateOf(setOf(0)) }
    var multiSelection by remember { mutableStateOf(setOf<Int>()) }

    val singleOptions = listOf(
        FluxOptionItem(
            title = "Standard Delivery",
            subtitle = "5-7 business days"
        ),
        FluxOptionItem(
            title = "Express Delivery",
            subtitle = "2-3 business days"
        ),
        FluxOptionItem(
            title = "Overnight Delivery",
            subtitle = "Next business day"
        )
    )

    val multiOptions = listOf(
        FluxOptionItem(
            title = "Email Notifications",
            subtitle = "Receive updates via email"
        ),
        FluxOptionItem(
            title = "SMS Notifications",
            subtitle = "Receive updates via text message"
        ),
        FluxOptionItem(
            title = "Push Notifications",
            subtitle = "Receive in-app push alerts"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "OptionCard",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Single-select mode
        Text(
            text = "Single Select",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        Text(
            text = "Choose a delivery method:",
            style = FluxTypography.body,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxOptionCard(
            options = singleOptions,
            selectedIndices = singleSelection,
            modifier = Modifier.fillMaxWidth(),
            selectionMode = FluxSelectionMode.Single,
            onSelectionChanged = { singleSelection = it }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))
        Text(
            text = "Selected: ${singleOptions.getOrNull(singleSelection.firstOrNull() ?: -1)?.title ?: "None"}",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Multi-select mode
        Text(
            text = "Multi Select",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        Text(
            text = "Choose notification channels:",
            style = FluxTypography.body,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxOptionCard(
            options = multiOptions,
            selectedIndices = multiSelection,
            modifier = Modifier.fillMaxWidth(),
            selectionMode = FluxSelectionMode.Multi,
            onSelectionChanged = { multiSelection = it }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))
        Text(
            text = "Selected: ${multiSelection.map { multiOptions[it].title }.joinToString(", ").ifEmpty { "None" }}",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
