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
import com.fluxds.foundation.atoms.FluxCheckBox
import com.fluxds.foundation.atoms.FluxCheckBoxSize
import com.fluxds.foundation.atoms.FluxCheckBoxStyle
import com.fluxds.foundation.atoms.FluxDivider

@Composable
fun CheckBoxShowcase() {
    val colors = FluxColors.current

    var filledChecked by remember { mutableStateOf(true) }
    var outlinedChecked by remember { mutableStateOf(false) }

    var smallChecked by remember { mutableStateOf(false) }
    var mediumChecked by remember { mutableStateOf(true) }
    var largeChecked by remember { mutableStateOf(false) }

    var labelChecked1 by remember { mutableStateOf(true) }
    var labelChecked2 by remember { mutableStateOf(false) }
    var labelChecked3 by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "CheckBox",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Styles ---
        Text(
            text = "Styles",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxCheckBox(
            isChecked = filledChecked,
            label = "Filled style",
            style = FluxCheckBoxStyle.Filled,
            onToggle = { filledChecked = it }
        )

        FluxCheckBox(
            isChecked = outlinedChecked,
            label = "Outlined style",
            style = FluxCheckBoxStyle.Outlined,
            onToggle = { outlinedChecked = it }
        )

        FluxDivider()

        // --- Sizes ---
        Text(
            text = "Sizes",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxCheckBox(
            isChecked = smallChecked,
            label = "Small checkbox",
            size = FluxCheckBoxSize.Small,
            onToggle = { smallChecked = it }
        )

        FluxCheckBox(
            isChecked = mediumChecked,
            label = "Medium checkbox",
            size = FluxCheckBoxSize.Medium,
            onToggle = { mediumChecked = it }
        )

        FluxCheckBox(
            isChecked = largeChecked,
            label = "Large checkbox",
            size = FluxCheckBoxSize.Large,
            onToggle = { largeChecked = it }
        )

        FluxDivider()

        // --- With Labels ---
        Text(
            text = "With Labels",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxCheckBox(
            isChecked = labelChecked1,
            label = "Accept Terms and Conditions",
            onToggle = { labelChecked1 = it }
        )

        FluxCheckBox(
            isChecked = labelChecked2,
            label = "Subscribe to newsletter",
            onToggle = { labelChecked2 = it }
        )

        FluxCheckBox(
            isChecked = labelChecked3,
            label = "Remember my preferences",
            onToggle = { labelChecked3 = it }
        )

        FluxDivider()

        // --- Custom Color ---
        Text(
            text = "Custom Color",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxCheckBox(
            isChecked = true,
            label = "Error color",
            color = colors.error,
            onToggle = {}
        )

        FluxCheckBox(
            isChecked = true,
            label = "Success color",
            color = colors.success,
            onToggle = {}
        )

        FluxDivider()

        // --- Disabled State ---
        Text(
            text = "Disabled State",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxCheckBox(
            isChecked = true,
            label = "Disabled checked",
            isDisabled = true,
            onToggle = {}
        )

        FluxCheckBox(
            isChecked = false,
            label = "Disabled unchecked",
            isDisabled = true,
            onToggle = {}
        )
    }
}
