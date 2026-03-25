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
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonSize
import com.fluxds.foundation.atoms.FluxButtonVariant
import com.fluxds.foundation.molecules.FluxAlertVariant
import com.fluxds.foundation.molecules.FluxAlertView

@Composable
fun AlertViewShowcase() {
    val colors = FluxColors.current

    var infoVisible by remember { mutableStateOf(true) }
    var successVisible by remember { mutableStateOf(true) }
    var warningVisible by remember { mutableStateOf(true) }
    var errorVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "AlertView",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Info variant
        Text(
            text = "Info",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxAlertView(
            variant = FluxAlertVariant.Info,
            title = "Information",
            message = "Your account settings have been updated. Changes will take effect shortly.",
            modifier = Modifier.fillMaxWidth(),
            isVisible = infoVisible,
            isDismissible = true,
            onDismiss = { infoVisible = false }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Success variant
        Text(
            text = "Success",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxAlertView(
            variant = FluxAlertVariant.Success,
            title = "Payment Successful",
            message = "Your transaction has been completed. A receipt has been sent to your email.",
            modifier = Modifier.fillMaxWidth(),
            isVisible = successVisible,
            isDismissible = true,
            onDismiss = { successVisible = false }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Warning variant
        Text(
            text = "Warning",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxAlertView(
            variant = FluxAlertVariant.Warning,
            title = "Low Balance",
            message = "Your account balance is below the minimum threshold. Please add funds.",
            modifier = Modifier.fillMaxWidth(),
            isVisible = warningVisible,
            isDismissible = true,
            onDismiss = { warningVisible = false }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Error variant
        Text(
            text = "Error",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxAlertView(
            variant = FluxAlertVariant.Error,
            title = "Connection Failed",
            message = "Unable to reach the server. Please check your internet connection and try again.",
            modifier = Modifier.fillMaxWidth(),
            isVisible = errorVisible,
            isDismissible = true,
            onDismiss = { errorVisible = false }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Reset button
        if (!infoVisible || !successVisible || !warningVisible || !errorVisible) {
            FluxButton(
                title = "Reset All Alerts",
                variant = FluxButtonVariant.Secondary,
                size = FluxButtonSize.Medium,
                onClick = {
                    infoVisible = true
                    successVisible = true
                    warningVisible = true
                    errorVisible = true
                }
            )
            Spacer(modifier = Modifier.height(FluxSpacing.lg))
        }
    }
}
