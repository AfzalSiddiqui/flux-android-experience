package com.fluxds.experience.screens.catalog.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonSize
import com.fluxds.foundation.atoms.FluxButtonVariant
import com.fluxds.foundation.molecules.FluxCard
import com.fluxds.foundation.molecules.FluxCardFlap

@Composable
fun CardFlapShowcase() {
    val colors = FluxColors.current

    var isFlipped by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CardFlap",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        Text(
            text = "A card that flips between front and back faces with a 3D rotation animation.",
            style = FluxTypography.body,
            color = colors.textSecondary,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Card flip
        FluxCardFlap(
            isFlipped = isFlipped,
            modifier = Modifier.fillMaxWidth(),
            front = {
                FluxCard(
                    modifier = Modifier.fillMaxWidth(),
                    padding = FluxSpacing.lg
                ) {
                    Column {
                        Text(
                            text = "Front Side",
                            style = FluxTypography.title2,
                            color = colors.textPrimary
                        )
                        Spacer(modifier = Modifier.height(FluxSpacing.xs))
                        Text(
                            text = "Platinum Card",
                            style = FluxTypography.headline,
                            color = colors.primary
                        )
                        Spacer(modifier = Modifier.height(FluxSpacing.sm))
                        Text(
                            text = "**** **** **** 4289",
                            style = FluxTypography.title3,
                            color = colors.textPrimary
                        )
                        Spacer(modifier = Modifier.height(FluxSpacing.xs))
                        Text(
                            text = "CARDHOLDER: JOHN DOE",
                            style = FluxTypography.caption,
                            color = colors.textSecondary
                        )
                        Text(
                            text = "VALID THRU: 12/28",
                            style = FluxTypography.caption,
                            color = colors.textSecondary
                        )
                    }
                }
            },
            back = {
                FluxCard(
                    modifier = Modifier.fillMaxWidth(),
                    padding = FluxSpacing.lg
                ) {
                    Column {
                        Text(
                            text = "Back Side",
                            style = FluxTypography.title2,
                            color = colors.textPrimary
                        )
                        Spacer(modifier = Modifier.height(FluxSpacing.xs))
                        Text(
                            text = "Card Details",
                            style = FluxTypography.headline,
                            color = colors.primary
                        )
                        Spacer(modifier = Modifier.height(FluxSpacing.sm))
                        Text(
                            text = "CVV: ***",
                            style = FluxTypography.body,
                            color = colors.textPrimary
                        )
                        Text(
                            text = "Card Type: Visa Platinum",
                            style = FluxTypography.body,
                            color = colors.textPrimary
                        )
                        Text(
                            text = "Issued: March 2024",
                            style = FluxTypography.body,
                            color = colors.textPrimary
                        )
                        Spacer(modifier = Modifier.height(FluxSpacing.xs))
                        Text(
                            text = "For support call: +971-4-XXX-XXXX",
                            style = FluxTypography.footnote,
                            color = colors.textSecondary
                        )
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Flip button
        FluxButton(
            title = if (isFlipped) "Show Front" else "Show Back",
            variant = FluxButtonVariant.Primary,
            size = FluxButtonSize.Medium,
            onClick = { isFlipped = !isFlipped }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        Text(
            text = "Currently showing: ${if (isFlipped) "Back" else "Front"}",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
