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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxSegmentedControl
import com.fluxds.foundation.atoms.FluxSegmentedControlSize
import com.fluxds.foundation.atoms.FluxSegmentedControlStyle

@Composable
fun SegmentedControlShowcase() {
    val colors = FluxColors.current

    var filledIndex by remember { mutableIntStateOf(0) }
    var outlinedIndex by remember { mutableIntStateOf(1) }
    var smallIndex by remember { mutableIntStateOf(0) }
    var mediumIndex by remember { mutableIntStateOf(1) }
    var largeIndex by remember { mutableIntStateOf(2) }
    var twoItemIndex by remember { mutableIntStateOf(0) }
    var fourItemIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Segmented Control",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Styles ---
        Text(
            text = "Filled Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("Day", "Week", "Month"),
            selectedIndex = filledIndex,
            style = FluxSegmentedControlStyle.Filled,
            onSelectionChanged = { filledIndex = it }
        )

        Text(
            text = "Selected: ${listOf("Day", "Week", "Month")[filledIndex]}",
            style = FluxTypography.footnote,
            color = colors.primary
        )

        FluxDivider()

        Text(
            text = "Outlined Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("Day", "Week", "Month"),
            selectedIndex = outlinedIndex,
            style = FluxSegmentedControlStyle.Outlined,
            onSelectionChanged = { outlinedIndex = it }
        )

        Text(
            text = "Selected: ${listOf("Day", "Week", "Month")[outlinedIndex]}",
            style = FluxTypography.footnote,
            color = colors.primary
        )

        FluxDivider()

        // --- Sizes ---
        Text(
            text = "Small Size",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("A", "B", "C"),
            selectedIndex = smallIndex,
            size = FluxSegmentedControlSize.Small,
            onSelectionChanged = { smallIndex = it }
        )

        Text(
            text = "Medium Size",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("A", "B", "C"),
            selectedIndex = mediumIndex,
            size = FluxSegmentedControlSize.Medium,
            onSelectionChanged = { mediumIndex = it }
        )

        Text(
            text = "Large Size",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("A", "B", "C"),
            selectedIndex = largeIndex,
            size = FluxSegmentedControlSize.Large,
            onSelectionChanged = { largeIndex = it }
        )

        FluxDivider()

        // --- Different Item Counts ---
        Text(
            text = "Two Items",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("On", "Off"),
            selectedIndex = twoItemIndex,
            onSelectionChanged = { twoItemIndex = it }
        )

        Text(
            text = "Four Items",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxSegmentedControl(
            items = listOf("Q1", "Q2", "Q3", "Q4"),
            selectedIndex = fourItemIndex,
            onSelectionChanged = { fourItemIndex = it }
        )
    }
}
