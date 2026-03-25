package com.fluxds.experience.screens.catalog.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.ShoppingCart
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
import com.fluxds.foundation.molecules.FluxBoxGrid
import com.fluxds.foundation.molecules.FluxBoxGridItem
import com.fluxds.foundation.molecules.FluxSelectionMode

@Composable
fun BoxGridShowcase() {
    val colors = FluxColors.current

    var singleSelection by remember { mutableStateOf(setOf(0)) }
    var multiSelection by remember { mutableStateOf(setOf<Int>()) }

    val singleItems = listOf(
        FluxBoxGridItem(title = "Transfer", icon = Icons.Filled.AttachMoney),
        FluxBoxGridItem(title = "Cards", icon = Icons.Filled.CreditCard),
        FluxBoxGridItem(title = "Accounts", icon = Icons.Filled.AccountBalance),
        FluxBoxGridItem(title = "Mobile", icon = Icons.Filled.PhoneAndroid),
        FluxBoxGridItem(title = "Travel", icon = Icons.Filled.Flight),
        FluxBoxGridItem(title = "Shopping", icon = Icons.Filled.ShoppingCart)
    )

    val multiItems = listOf(
        FluxBoxGridItem(title = "Banking", icon = Icons.Filled.AccountBalance),
        FluxBoxGridItem(title = "Payments", icon = Icons.Filled.AttachMoney),
        FluxBoxGridItem(title = "Cards", icon = Icons.Filled.CreditCard),
        FluxBoxGridItem(title = "Mobile", icon = Icons.Filled.PhoneAndroid),
        FluxBoxGridItem(title = "Travel", icon = Icons.Filled.Flight),
        FluxBoxGridItem(title = "Shopping", icon = Icons.Filled.ShoppingCart)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "BoxGrid",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Single-select mode
        Text(
            text = "Single Select (3 columns)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        Text(
            text = "Tap to select one item:",
            style = FluxTypography.body,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxBoxGrid(
            items = singleItems,
            selectedIndices = singleSelection,
            modifier = Modifier
                .fillMaxWidth()
                .height(FluxSpacing.xxl * 5),
            columns = 3,
            selectionMode = FluxSelectionMode.Single,
            onSelectionChanged = { singleSelection = it }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))
        Text(
            text = "Selected: ${singleItems.getOrNull(singleSelection.firstOrNull() ?: -1)?.title ?: "None"}",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Multi-select mode
        Text(
            text = "Multi Select (3 columns)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        Text(
            text = "Tap to select multiple items:",
            style = FluxTypography.body,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxBoxGrid(
            items = multiItems,
            selectedIndices = multiSelection,
            modifier = Modifier
                .fillMaxWidth()
                .height(FluxSpacing.xxl * 5),
            columns = 3,
            selectionMode = FluxSelectionMode.Multi,
            onSelectionChanged = { multiSelection = it }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))
        Text(
            text = "Selected: ${multiSelection.sorted().map { multiItems[it].title }.joinToString(", ").ifEmpty { "None" }}",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
