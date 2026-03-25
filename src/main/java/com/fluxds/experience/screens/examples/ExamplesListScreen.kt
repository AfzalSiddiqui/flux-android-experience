package com.fluxds.experience.screens.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.molecules.FluxListRow

data class ExampleItem(val title: String, val route: String)

@Composable
fun ExamplesListScreen(navController: NavController) {
    val colors = FluxColors.current

    val examples = listOf(
        ExampleItem("Login Flow", "login_flow"),
        ExampleItem("Dashboard Flow", "dashboard_flow"),
        ExampleItem("Payment Flow", "payment_flow")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = FluxSpacing.md)
    ) {
        Text(
            text = "Examples",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(horizontal = FluxSpacing.md, vertical = FluxSpacing.sm)
        )

        examples.forEach { example ->
            FluxListRow(
                title = example.title,
                onPress = { navController.navigate(example.route) }
            )
        }
    }
}
