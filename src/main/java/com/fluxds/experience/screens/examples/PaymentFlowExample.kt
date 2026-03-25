package com.fluxds.experience.screens.examples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonSize
import com.fluxds.foundation.molecules.FluxOptionCard
import com.fluxds.foundation.molecules.FluxOptionItem
import com.fluxds.foundation.molecules.FluxSelectionMode
import com.fluxds.foundation.molecules.FluxTextField
import kotlinx.coroutines.delay

@Composable
fun PaymentFlowExample() {
    val colors = FluxColors.current

    var selectedRecipient by remember { mutableStateOf(setOf<Int>()) }
    var amount by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }
    var isComplete by remember { mutableStateOf(false) }

    val recipients = listOf(
        FluxOptionItem(
            title = "Alice Johnson",
            subtitle = "alice@example.com"
        ),
        FluxOptionItem(
            title = "Bob Smith",
            subtitle = "bob@example.com"
        ),
        FluxOptionItem(
            title = "Carol Williams",
            subtitle = "carol@example.com"
        )
    )

    LaunchedEffect(isProcessing) {
        if (isProcessing) {
            delay(2000L)
            isProcessing = false
            isComplete = true
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
        ) {
            Text(
                text = "Payment Flow",
                style = FluxTypography.largeTitle,
                color = colors.textPrimary
            )

            Spacer(modifier = Modifier.height(FluxSpacing.xs))

            // Recipient selection
            Text(
                text = "Select Recipient",
                style = FluxTypography.headline,
                color = colors.textSecondary
            )

            FluxOptionCard(
                options = recipients,
                selectedIndices = selectedRecipient,
                modifier = Modifier.fillMaxWidth(),
                selectionMode = FluxSelectionMode.Single,
                onSelectionChanged = { selectedRecipient = it }
            )

            Spacer(modifier = Modifier.height(FluxSpacing.xs))

            // Amount input
            Text(
                text = "Enter Amount",
                style = FluxTypography.headline,
                color = colors.textSecondary
            )

            FluxTextField(
                value = amount,
                onValueChange = { amount = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Amount (USD)",
                placeholder = "0.00",
                keyboardType = KeyboardType.Number,
                isEnabled = !isProcessing && !isComplete
            )

            Spacer(modifier = Modifier.height(FluxSpacing.sm))

            // Pay button
            FluxButton(
                title = "Pay Now",
                size = FluxButtonSize.Large,
                isLoading = isProcessing,
                isDisabled = selectedRecipient.isEmpty() || amount.isBlank() || isComplete,
                onClick = { isProcessing = true }
            )
        }

        // Success overlay
        AnimatedVisibility(
            visible = isComplete,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF4CAF50).copy(alpha = 0.92f)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Payment Complete",
                        modifier = Modifier.size(64.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "Payment Successful",
                        style = FluxTypography.title1,
                        color = Color.White
                    )
                    Text(
                        text = "$$amount sent to ${
                            recipients.getOrNull(selectedRecipient.firstOrNull() ?: -1)?.title ?: ""
                        }",
                        style = FluxTypography.body,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }
    }
}
