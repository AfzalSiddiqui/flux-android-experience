package com.fluxds.experience.screens.guidelines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxDivider

private data class GuidelineItem(val text: String, val isDo: Boolean)

private data class GuidelineSection(
    val title: String,
    val items: List<GuidelineItem>
)

private val guidelineSections = listOf(
    GuidelineSection(
        title = "Colors",
        items = listOf(
            GuidelineItem("Use semantic color tokens", isDo = true),
            GuidelineItem("Support light/dark mode", isDo = true),
            GuidelineItem("Hard-code hex colors", isDo = false),
            GuidelineItem("Ignore dark mode", isDo = false)
        )
    ),
    GuidelineSection(
        title = "Typography",
        items = listOf(
            GuidelineItem("Use FluxTypography styles", isDo = true),
            GuidelineItem("Support Dynamic Type", isDo = true),
            GuidelineItem("Use arbitrary font sizes", isDo = false),
            GuidelineItem("Mix different font families", isDo = false)
        )
    ),
    GuidelineSection(
        title = "Spacing",
        items = listOf(
            GuidelineItem("Use FluxSpacing tokens", isDo = true),
            GuidelineItem("Maintain consistent spacing", isDo = true),
            GuidelineItem("Use magic numbers", isDo = false),
            GuidelineItem("Mix spacing systems", isDo = false)
        )
    ),
    GuidelineSection(
        title = "Components",
        items = listOf(
            GuidelineItem("Use Flux components", isDo = true),
            GuidelineItem("Compose molecules from atoms", isDo = true),
            GuidelineItem("Build custom components from scratch", isDo = false),
            GuidelineItem("Bypass component API", isDo = false)
        )
    ),
    GuidelineSection(
        title = "Accessibility",
        items = listOf(
            GuidelineItem("Maintain 4.5:1 contrast ratio", isDo = true),
            GuidelineItem("Add contentDescription to interactive elements", isDo = true),
            GuidelineItem("Use color alone to convey info", isDo = false),
            GuidelineItem("Disable accessibility features", isDo = false)
        )
    )
)

@Composable
fun DosAndDontsScreen() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Guidelines",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary
        )

        guidelineSections.forEach { section ->
            GuidelineSectionView(section = section)
        }
    }
}

@Composable
private fun GuidelineSectionView(section: GuidelineSection) {
    val colors = FluxColors.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
    ) {
        Text(
            text = section.title,
            style = FluxTypography.headline,
            color = colors.textPrimary
        )

        FluxDivider()

        section.items.forEach { item ->
            GuidelineItemRow(item = item)
        }
    }
}

@Composable
private fun GuidelineItemRow(item: GuidelineItem) {
    val colors = FluxColors.current
    val indicatorColor = if (item.isDo) Color(0xFF34C759) else Color(0xFFFF3B30)
    val prefix = if (item.isDo) "Do: " else "Don't: "

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = FluxSpacing.xs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(indicatorColor)
        )

        Text(
            text = prefix + item.text,
            style = FluxTypography.body,
            color = colors.textPrimary
        )
    }
}
