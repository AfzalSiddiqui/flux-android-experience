package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxShimmer
import com.fluxds.foundation.atoms.FluxShimmerCard
import com.fluxds.foundation.atoms.FluxShimmerShape
import com.fluxds.foundation.atoms.FluxShimmerTextBlock
import com.fluxds.foundation.atoms.FluxToggle

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShimmerShowcase() {
    val colors = FluxColors.current
    var isAnimating by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Shimmer",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // --- Animation Toggle ---
        FluxToggle(
            isOn = isAnimating,
            label = "Animation",
            modifier = Modifier.fillMaxWidth(),
            onToggle = { isAnimating = it }
        )

        FluxDivider()

        // --- Line Shape ---
        Text(
            text = "Line Shape",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxShimmer(
            shape = FluxShimmerShape.Line,
            isAnimating = isAnimating,
            height = 12.dp
        )

        FluxShimmer(
            shape = FluxShimmerShape.Line,
            isAnimating = isAnimating,
            height = 16.dp
        )

        FluxShimmer(
            shape = FluxShimmerShape.Line,
            isAnimating = isAnimating,
            height = 20.dp,
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        FluxDivider()

        // --- Circle Shape ---
        Text(
            text = "Circle Shape",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(FluxSpacing.md),
            verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxShimmer(
                    shape = FluxShimmerShape.Circle,
                    isAnimating = isAnimating,
                    width = 40.dp
                )
                Text(text = "40dp", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxShimmer(
                    shape = FluxShimmerShape.Circle,
                    isAnimating = isAnimating,
                    width = 60.dp
                )
                Text(text = "60dp", style = FluxTypography.caption, color = colors.textSecondary)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FluxShimmer(
                    shape = FluxShimmerShape.Circle,
                    isAnimating = isAnimating,
                    width = 80.dp
                )
                Text(text = "80dp", style = FluxTypography.caption, color = colors.textSecondary)
            }
        }

        FluxDivider()

        // --- Rectangle Shape ---
        Text(
            text = "Rectangle Shape",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxShimmer(
            shape = FluxShimmerShape.Rectangle,
            isAnimating = isAnimating,
            width = 200.dp,
            height = 100.dp,
            modifier = Modifier.fillMaxWidth()
        )

        FluxDivider()

        // --- Text Block ---
        Text(
            text = "Shimmer Text Block",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxShimmerTextBlock(
            lines = 3,
            isAnimating = isAnimating,
            modifier = Modifier.fillMaxWidth()
        )

        FluxDivider()

        Text(
            text = "Shimmer Text Block (5 lines)",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxShimmerTextBlock(
            lines = 5,
            isAnimating = isAnimating,
            modifier = Modifier.fillMaxWidth()
        )

        FluxDivider()

        // --- Shimmer Card ---
        Text(
            text = "Shimmer Card",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        FluxShimmerCard(
            isAnimating = isAnimating,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
