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
import com.fluxds.foundation.atoms.FluxRadioButton
import com.fluxds.foundation.atoms.FluxRadioButtonSize

@Composable
fun RadioButtonShowcase() {
    val colors = FluxColors.current

    var selectedOption by remember { mutableIntStateOf(0) }
    var selectedSize by remember { mutableIntStateOf(1) }
    var selectedColor by remember { mutableIntStateOf(0) }

    val options = listOf("Option A", "Option B", "Option C")
    val sizeLabels = listOf("Small radio", "Medium radio", "Large radio")
    val sizes = listOf(FluxRadioButtonSize.Small, FluxRadioButtonSize.Medium, FluxRadioButtonSize.Large)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "RadioButton",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Single-Select Group ---
        Text(
            text = "Single-Select Group",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        options.forEachIndexed { index, option ->
            FluxRadioButton(
                isSelected = selectedOption == index,
                label = option,
                onSelect = { selectedOption = index }
            )
        }

        Text(
            text = "Selected: ${options[selectedOption]}",
            style = FluxTypography.footnote,
            color = colors.primary
        )

        FluxDivider()

        // --- Sizes ---
        Text(
            text = "Sizes",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        sizeLabels.forEachIndexed { index, label ->
            FluxRadioButton(
                isSelected = selectedSize == index,
                label = label,
                size = sizes[index],
                onSelect = { selectedSize = index }
            )
        }

        FluxDivider()

        // --- Custom Colors ---
        Text(
            text = "Custom Colors",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        val colorOptions = listOf(
            "Primary" to colors.primary,
            "Error" to colors.error,
            "Success" to colors.success
        )

        colorOptions.forEachIndexed { index, (label, color) ->
            FluxRadioButton(
                isSelected = selectedColor == index,
                label = label,
                color = color,
                onSelect = { selectedColor = index }
            )
        }

        FluxDivider()

        // --- Disabled State ---
        Text(
            text = "Disabled State",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxRadioButton(
            isSelected = true,
            label = "Disabled selected",
            isDisabled = true,
            onSelect = {}
        )

        FluxRadioButton(
            isSelected = false,
            label = "Disabled unselected",
            isDisabled = true,
            onSelect = {}
        )
    }
}
