package com.fluxds.experience.screens.catalog.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
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
import com.fluxds.foundation.molecules.FluxListRow

@Composable
fun ListRowShowcase() {
    val colors = FluxColors.current
    var tappedItem by remember { mutableStateOf("None") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "ListRow",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        Text(
            text = "Last tapped: $tappedItem",
            style = FluxTypography.footnote,
            color = colors.textSecondary,
            modifier = Modifier.padding(bottom = FluxSpacing.sm)
        )

        // Basic with icon and chevron
        Text(
            text = "With Icon & Chevron",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxListRow(
            title = "Profile",
            icon = Icons.Filled.AccountCircle,
            showChevron = true,
            onPress = { tappedItem = "Profile" }
        )
        FluxDivider()

        // With subtitle
        Text(
            text = "With Subtitle",
            style = FluxTypography.headline,
            color = colors.textSecondary,
            modifier = Modifier.padding(top = FluxSpacing.md)
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxListRow(
            title = "Notifications",
            subtitle = "Manage your notification preferences",
            icon = Icons.Filled.Notifications,
            showChevron = true,
            onPress = { tappedItem = "Notifications" }
        )
        FluxDivider()

        // Without chevron
        Text(
            text = "Without Chevron",
            style = FluxTypography.headline,
            color = colors.textSecondary,
            modifier = Modifier.padding(top = FluxSpacing.md)
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxListRow(
            title = "Favorites",
            subtitle = "Your saved items",
            icon = Icons.Filled.Star,
            showChevron = false
        )
        FluxDivider()

        // Tappable without icon
        Text(
            text = "No Icon, Tappable",
            style = FluxTypography.headline,
            color = colors.textSecondary,
            modifier = Modifier.padding(top = FluxSpacing.md)
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxListRow(
            title = "General Settings",
            subtitle = "App configuration and preferences",
            showChevron = true,
            onPress = { tappedItem = "General Settings" }
        )
        FluxDivider()

        // With icon, no subtitle, tappable
        Text(
            text = "Icon Only, No Subtitle",
            style = FluxTypography.headline,
            color = colors.textSecondary,
            modifier = Modifier.padding(top = FluxSpacing.md)
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxListRow(
            title = "Settings",
            icon = Icons.Filled.Settings,
            showChevron = true,
            onPress = { tappedItem = "Settings" }
        )
        FluxDivider()

        // Non-tappable, no chevron, no icon
        Text(
            text = "Static (Non-Tappable)",
            style = FluxTypography.headline,
            color = colors.textSecondary,
            modifier = Modifier.padding(top = FluxSpacing.md)
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxListRow(
            title = "App Version",
            subtitle = "1.0.0 (Build 42)",
            showChevron = false
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
