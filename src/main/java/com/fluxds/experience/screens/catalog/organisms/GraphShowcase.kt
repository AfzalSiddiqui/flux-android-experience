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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.organisms.FluxChartType
import com.fluxds.foundation.organisms.FluxGraph
import com.fluxds.foundation.organisms.FluxGraphData

@Composable
fun GraphShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Graph",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Bar Chart ---
        Text(
            text = "Bar Chart",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxGraph(
            data = FluxGraphData(
                labels = listOf("Mon", "Tue", "Wed", "Thu", "Fri"),
                values = listOf(45f, 72f, 58f, 90f, 63f),
                colors = listOf(
                    colors.primary,
                    colors.primary,
                    colors.primary,
                    colors.primary,
                    colors.primary
                )
            ),
            chartType = FluxChartType.Bar,
            modifier = Modifier
                .fillMaxWidth()
                .height(FluxSpacing.xl * 8)
        )

        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // --- Line Chart ---
        Text(
            text = "Line Chart",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxGraph(
            data = FluxGraphData(
                labels = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun"),
                values = listOf(30f, 55f, 42f, 78f, 65f, 88f),
                colors = listOf(colors.success)
            ),
            chartType = FluxChartType.Line,
            modifier = Modifier
                .fillMaxWidth()
                .height(FluxSpacing.xl * 8)
        )

        Spacer(modifier = Modifier.height(FluxSpacing.md))

        // --- Pie Chart ---
        Text(
            text = "Pie Chart",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxGraph(
            data = FluxGraphData(
                labels = listOf("Sales", "Marketing", "Engineering", "Support"),
                values = listOf(35f, 25f, 28f, 12f),
                colors = listOf(
                    colors.primary,
                    colors.success,
                    colors.warning,
                    colors.error
                )
            ),
            chartType = FluxChartType.Pie,
            modifier = Modifier
                .fillMaxWidth()
                .height(FluxSpacing.xl * 8)
        )

        Spacer(modifier = Modifier.height(FluxSpacing.md))
    }
}
