package com.fluxds.experience.screens.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.CallReceived
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalGasStation
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxCard
import com.fluxds.foundation.molecules.FluxListRow

private data class QuickAction(val title: String, val icon: ImageVector)

private data class Transaction(
    val merchant: String,
    val date: String,
    val amount: String,
    val icon: ImageVector
)

@Composable
fun DashboardFlowExample() {
    val colors = FluxColors.current

    val quickActions = listOf(
        QuickAction("Send", Icons.Filled.Send),
        QuickAction("Request", Icons.Filled.CallReceived),
        QuickAction("Pay", Icons.Filled.CreditCard),
        QuickAction("Top Up", Icons.Filled.ArrowUpward)
    )

    val transactions = listOf(
        Transaction("Amazon", "Mar 24, 2026", "-$54.99", Icons.Filled.ShoppingCart),
        Transaction("Starbucks", "Mar 23, 2026", "-$6.50", Icons.Filled.Fastfood),
        Transaction("Shell Gas", "Mar 22, 2026", "-$42.00", Icons.Filled.LocalGasStation),
        Transaction("Netflix", "Mar 21, 2026", "-$15.99", Icons.Filled.Movie),
        Transaction("Pharmacy Plus", "Mar 20, 2026", "-$23.75", Icons.Filled.HealthAndSafety)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Dashboard Flow",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )

        // Balance card
        FluxCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(FluxSpacing.xxs)
            ) {
                Text(
                    text = "Total Balance",
                    style = FluxTypography.subheadline,
                    color = colors.textSecondary
                )
                Text(
                    text = "$12,450.00",
                    style = FluxTypography.largeTitle,
                    color = colors.textPrimary
                )
            }
        }

        // Quick actions
        Text(
            text = "Quick Actions",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            quickActions.forEach { action ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(FluxSpacing.xxs)
                ) {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = action.title,
                        modifier = Modifier.size(28.dp),
                        tint = colors.primary
                    )
                    Text(
                        text = action.title,
                        style = FluxTypography.caption,
                        color = colors.textPrimary
                    )
                }
            }
        }

        // Transaction list
        Text(
            text = "Recent Transactions",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                transactions.forEach { transaction ->
                    FluxListRow(
                        title = transaction.merchant,
                        subtitle = transaction.date,
                        icon = transaction.icon,
                        showChevron = false
                    )
                }
            }
        }
    }
}
