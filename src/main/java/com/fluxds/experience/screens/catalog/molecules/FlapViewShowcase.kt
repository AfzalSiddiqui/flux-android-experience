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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxCard
import com.fluxds.foundation.molecules.FluxFlapStyle
import com.fluxds.foundation.molecules.FluxFlapView

@Composable
fun FlapViewShowcase() {
    val colors = FluxColors.current

    var underlinedIndex by remember { mutableIntStateOf(0) }
    var filledIndex by remember { mutableIntStateOf(0) }
    var pillIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Overview", "Details", "Reviews")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "FlapView",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Underlined style
        Text(
            text = "Underlined Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxFlapView(
            tabs = tabs,
            selectedIndex = underlinedIndex,
            onTabChanged = { underlinedIndex = it },
            modifier = Modifier.fillMaxWidth(),
            style = FluxFlapStyle.Underlined
        ) { index ->
            FluxCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = when (index) {
                        0 -> "This is the Overview tab. It provides a high-level summary of the content."
                        1 -> "This is the Details tab. It shows in-depth technical specifications and metadata."
                        else -> "This is the Reviews tab. It displays user feedback and ratings."
                    },
                    style = FluxTypography.body,
                    color = colors.textPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Filled style
        Text(
            text = "Filled Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxFlapView(
            tabs = listOf("All", "Active", "Archived"),
            selectedIndex = filledIndex,
            onTabChanged = { filledIndex = it },
            modifier = Modifier.fillMaxWidth(),
            style = FluxFlapStyle.Filled
        ) { index ->
            FluxCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = when (index) {
                        0 -> "Showing all 24 items across all categories."
                        1 -> "Showing 18 active items currently in progress."
                        else -> "Showing 6 archived items from previous periods."
                    },
                    style = FluxTypography.body,
                    color = colors.textPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Pill style
        Text(
            text = "Pill Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxFlapView(
            tabs = listOf("Day", "Week", "Month"),
            selectedIndex = pillIndex,
            onTabChanged = { pillIndex = it },
            modifier = Modifier.fillMaxWidth(),
            style = FluxFlapStyle.Pill
        ) { index ->
            FluxCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = when (index) {
                        0 -> "Daily view: Showing transactions from today, March 25, 2026."
                        1 -> "Weekly view: Showing transactions from the past 7 days."
                        else -> "Monthly view: Showing transactions from March 2026."
                    },
                    style = FluxTypography.body,
                    color = colors.textPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
