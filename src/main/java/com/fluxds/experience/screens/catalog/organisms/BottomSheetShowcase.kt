package com.fluxds.experience.screens.catalog.organisms

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonVariant
import com.fluxds.foundation.organisms.FluxBottomSheet
import com.fluxds.foundation.organisms.FluxBottomSheetDetent

@Composable
fun BottomSheetShowcase() {
    val colors = FluxColors.current

    var isPresented by remember { mutableStateOf(false) }
    var detent by remember { mutableStateOf(FluxBottomSheetDetent.Half) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Bottom Sheet",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Quarter Detent ---
        Text(
            text = "Sheet Detents",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxButton(
            title = "Open Quarter Sheet",
            variant = FluxButtonVariant.Primary,
            onClick = {
                detent = FluxBottomSheetDetent.Quarter
                isPresented = true
            }
        )

        // --- Half Detent ---
        FluxButton(
            title = "Open Half Sheet",
            variant = FluxButtonVariant.Secondary,
            onClick = {
                detent = FluxBottomSheetDetent.Half
                isPresented = true
            }
        )

        // --- Large Detent ---
        FluxButton(
            title = "Open Large Sheet",
            variant = FluxButtonVariant.Destructive,
            onClick = {
                detent = FluxBottomSheetDetent.Large
                isPresented = true
            }
        )

        Spacer(modifier = Modifier.height(FluxSpacing.md))

        Text(
            text = "Tap any button above to open the bottom sheet at a different height.",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )
    }

    if (isPresented) {
        FluxBottomSheet(
            isPresented = isPresented,
            detent = detent,
            onDismiss = { isPresented = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(FluxSpacing.lg),
                verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
            ) {
                Text(
                    text = "Bottom Sheet Content",
                    style = FluxTypography.title2,
                    color = colors.textPrimary
                )

                Text(
                    text = "This sheet is displayed at the ${
                        when (detent) {
                            FluxBottomSheetDetent.Quarter -> "Quarter"
                            FluxBottomSheetDetent.Half -> "Half"
                            FluxBottomSheetDetent.Large -> "Large"
                        }
                    } detent. You can customize the content and height of the sheet.",
                    style = FluxTypography.body,
                    color = colors.textSecondary
                )

                Spacer(modifier = Modifier.height(FluxSpacing.sm))

                FluxButton(
                    title = "Dismiss",
                    variant = FluxButtonVariant.Secondary,
                    onClick = { isPresented = false }
                )
            }
        }
    }
}
