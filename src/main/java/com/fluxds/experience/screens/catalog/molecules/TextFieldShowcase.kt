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
import androidx.compose.ui.text.input.KeyboardType
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxTextField

@Composable
fun TextFieldShowcase() {
    val colors = FluxColors.current

    var nameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var errorValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var disabledValue by remember { mutableStateOf("Disabled input") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "TextField",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // Basic with label
        Text(
            text = "With Label",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxTextField(
            value = nameValue,
            onValueChange = { nameValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Full Name",
            placeholder = "Enter your name"
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // With placeholder and keyboard type
        Text(
            text = "Email Keyboard Type",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxTextField(
            value = emailValue,
            onValueChange = { emailValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Email Address",
            placeholder = "you@example.com",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // With error message
        Text(
            text = "With Error Message",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxTextField(
            value = errorValue,
            onValueChange = { errorValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Username",
            placeholder = "Choose a username",
            errorMessage = if (errorValue.length < 3 && errorValue.isNotEmpty()) {
                "Username must be at least 3 characters"
            } else if (errorValue.isEmpty()) {
                "This field is required"
            } else {
                null
            }
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Secure field (password)
        Text(
            text = "Secure Field (Password)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxTextField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            placeholder = "Enter your password",
            isSecure = true,
            keyboardType = KeyboardType.Password
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))

        // Disabled field
        Text(
            text = "Disabled",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        FluxTextField(
            value = disabledValue,
            onValueChange = { disabledValue = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Disabled Field",
            isEnabled = false
        )
        Spacer(modifier = Modifier.height(FluxSpacing.lg))
    }
}
