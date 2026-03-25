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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.fluxds.ds.tokens.FluxRadius
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxButton
import com.fluxds.foundation.atoms.FluxButtonSize
import com.fluxds.foundation.molecules.FluxTextField
import kotlinx.coroutines.delay

@Composable
fun LoginFlowExample() {
    val colors = FluxColors.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000L)
            isLoading = false
            isSuccess = true
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
                text = "Login Flow",
                style = FluxTypography.largeTitle,
                color = colors.textPrimary
            )

            Spacer(modifier = Modifier.height(FluxSpacing.sm))

            Text(
                text = "Sign in to your account",
                style = FluxTypography.body,
                color = colors.textSecondary
            )

            Spacer(modifier = Modifier.height(FluxSpacing.xs))

            FluxTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Email",
                placeholder = "you@example.com",
                keyboardType = KeyboardType.Email,
                isEnabled = !isLoading && !isSuccess
            )

            FluxTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = "Password",
                placeholder = "Enter your password",
                isSecure = true,
                keyboardType = KeyboardType.Password,
                isEnabled = !isLoading && !isSuccess
            )

            Spacer(modifier = Modifier.height(FluxSpacing.sm))

            FluxButton(
                title = "Log In",
                size = FluxButtonSize.Large,
                isLoading = isLoading,
                isDisabled = email.isBlank() || password.isBlank() || isSuccess,
                onClick = { isLoading = true }
            )
        }

        // Success overlay
        AnimatedVisibility(
            visible = isSuccess,
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
                        contentDescription = "Success",
                        modifier = Modifier.size(64.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "Login Successful",
                        style = FluxTypography.title1,
                        color = Color.White
                    )
                }
            }
        }
    }
}
