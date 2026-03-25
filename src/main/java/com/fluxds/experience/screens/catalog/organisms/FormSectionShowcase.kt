package com.fluxds.experience.screens.catalog.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.fluxds.foundation.atoms.FluxToggle
import com.fluxds.foundation.molecules.FluxTextField
import com.fluxds.foundation.organisms.FluxFormSection

@Composable
fun FormSectionShowcase() {
    val colors = FluxColors.current

    var nameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var phoneValue by remember { mutableStateOf("") }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Form Section",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Personal Info Section ---
        Text(
            text = "With Text Fields",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxFormSection(title = "Personal Info") {
            FluxTextField(
                value = nameValue,
                onValueChange = { nameValue = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Name",
                placeholder = "Enter your full name"
            )

            FluxTextField(
                value = emailValue,
                onValueChange = { emailValue = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Email",
                placeholder = "you@example.com",
                keyboardType = KeyboardType.Email
            )

            FluxTextField(
                value = phoneValue,
                onValueChange = { phoneValue = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Phone",
                placeholder = "+1 (555) 000-0000",
                keyboardType = KeyboardType.Phone
            )
        }

        // --- Preferences Section ---
        Text(
            text = "With Toggles",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxFormSection(title = "Preferences") {
            FluxToggle(
                isOn = notificationsEnabled,
                label = "Enable Notifications",
                modifier = Modifier.fillMaxWidth(),
                onToggle = { notificationsEnabled = it }
            )

            FluxToggle(
                isOn = darkModeEnabled,
                label = "Dark Mode",
                modifier = Modifier.fillMaxWidth(),
                onToggle = { darkModeEnabled = it }
            )
        }
    }
}
