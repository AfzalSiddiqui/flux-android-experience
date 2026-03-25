package com.fluxds.experience.screens.catalog.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
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
import com.fluxds.foundation.molecules.FluxExpandableStyle
import com.fluxds.foundation.molecules.FluxExpandableView

@Composable
fun ExpandableViewShowcase() {
    val colors = FluxColors.current

    var cardExpanded by remember { mutableStateOf(false) }
    var plainExpanded by remember { mutableStateOf(false) }
    var borderedExpanded by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "ExpandableView",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Card style
        Text(
            text = "Card Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxExpandableView(
            title = "Account Details",
            isExpanded = cardExpanded,
            onToggle = { cardExpanded = it },
            icon = Icons.Filled.Info,
            style = FluxExpandableStyle.Card
        ) {
            Text(
                text = "Your account is active and in good standing. Your current plan includes premium features with unlimited access to all services. The next billing cycle starts on April 1, 2026.",
                style = FluxTypography.body,
                color = colors.textPrimary
            )
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Plain style
        Text(
            text = "Plain Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxExpandableView(
            title = "Frequently Asked Questions",
            isExpanded = plainExpanded,
            onToggle = { plainExpanded = it },
            icon = Icons.Filled.Help,
            style = FluxExpandableStyle.Plain
        ) {
            Column {
                Text(
                    text = "Q: How do I reset my password?",
                    style = FluxTypography.headline,
                    color = colors.textPrimary
                )
                Spacer(modifier = Modifier.height(FluxSpacing.xxs))
                Text(
                    text = "A: Go to Settings > Security > Change Password and follow the instructions.",
                    style = FluxTypography.body,
                    color = colors.textSecondary
                )
                Spacer(modifier = Modifier.height(FluxSpacing.sm))
                Text(
                    text = "Q: Where can I find my transaction history?",
                    style = FluxTypography.headline,
                    color = colors.textPrimary
                )
                Spacer(modifier = Modifier.height(FluxSpacing.xxs))
                Text(
                    text = "A: Navigate to the Activity tab on the home screen to see all recent transactions.",
                    style = FluxTypography.body,
                    color = colors.textSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Bordered style
        Text(
            text = "Bordered Style",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxExpandableView(
            title = "Advanced Settings",
            isExpanded = borderedExpanded,
            onToggle = { borderedExpanded = it },
            icon = Icons.Filled.Settings,
            style = FluxExpandableStyle.Bordered
        ) {
            Column {
                Text(
                    text = "These settings allow fine-grained control over app behavior. Modify with caution.",
                    style = FluxTypography.body,
                    color = colors.textPrimary
                )
                Spacer(modifier = Modifier.height(FluxSpacing.xs))
                Text(
                    text = "Cache: Enabled\nSync Interval: 15 min\nDebug Mode: Off",
                    style = FluxTypography.footnote,
                    color = colors.textSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
