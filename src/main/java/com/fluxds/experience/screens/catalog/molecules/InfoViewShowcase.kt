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
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxInfoView
import com.fluxds.foundation.molecules.FluxInfoViewAlignment

@Composable
fun InfoViewShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "InfoView",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Horizontal alignment examples
        Text(
            text = "Horizontal Alignment",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))

        FluxInfoView(
            icon = Icons.Filled.Info,
            title = "Account Overview",
            description = "View your account details and recent activity.",
            modifier = Modifier.fillMaxWidth(),
            alignment = FluxInfoViewAlignment.Horizontal
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        FluxInfoView(
            icon = Icons.Filled.CreditCard,
            title = "Payment Methods",
            description = "Manage your saved cards and payment options.",
            modifier = Modifier.fillMaxWidth(),
            alignment = FluxInfoViewAlignment.Horizontal
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        FluxInfoView(
            icon = Icons.Filled.Security,
            title = "Security",
            description = "Two-factor authentication is enabled for your account.",
            modifier = Modifier.fillMaxWidth(),
            alignment = FluxInfoViewAlignment.Horizontal
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Vertical alignment examples
        Text(
            text = "Vertical Alignment",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))

        FluxInfoView(
            icon = Icons.Filled.AccountBalance,
            title = "Total Balance",
            description = "AED 24,500.00",
            modifier = Modifier.fillMaxWidth(),
            alignment = FluxInfoViewAlignment.Vertical
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        FluxInfoView(
            icon = Icons.Filled.CreditCard,
            title = "Active Cards",
            description = "3 cards linked to your account",
            modifier = Modifier.fillMaxWidth(),
            alignment = FluxInfoViewAlignment.Vertical
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))

        // Without description
        Text(
            text = "Without Description",
            style = FluxTypography.headline,
            color = colors.textSecondary,
            modifier = Modifier.padding(top = FluxSpacing.md)
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))

        FluxInfoView(
            icon = Icons.Filled.Info,
            title = "Title Only",
            modifier = Modifier.fillMaxWidth(),
            alignment = FluxInfoViewAlignment.Horizontal
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
