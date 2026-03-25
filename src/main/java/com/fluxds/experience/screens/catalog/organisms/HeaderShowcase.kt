package com.fluxds.experience.screens.catalog.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.organisms.FluxHeader

@Composable
fun HeaderShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Header",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Title Only ---
        Text(
            text = "Title Only",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxHeader(
            title = "Dashboard"
        )

        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        // --- Title + Subtitle ---
        Text(
            text = "Title + Subtitle",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxHeader(
            title = "Profile",
            subtitle = "Manage your account settings"
        )

        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        // --- With Leading Back Button ---
        Text(
            text = "With Leading Back Button",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxHeader(
            title = "Details",
            subtitle = "View item information",
            leadingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = colors.textPrimary
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        // --- With Trailing Action Button ---
        Text(
            text = "With Trailing Action Button",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxHeader(
            title = "Settings",
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                        tint = colors.textPrimary
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        // --- Full Header (Leading + Title + Subtitle + Trailing) ---
        Text(
            text = "Full Header",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxHeader(
            title = "Notifications",
            subtitle = "3 new messages",
            leadingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = colors.textPrimary
                    )
                }
            },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                        tint = colors.textPrimary
                    )
                }
            }
        )
    }
}
