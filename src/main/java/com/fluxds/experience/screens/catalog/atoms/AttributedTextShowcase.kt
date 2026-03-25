package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxText
import com.fluxds.foundation.atoms.FluxTextSegment
import com.fluxds.foundation.atoms.FluxTextStyle
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun AttributedTextShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "Attributed Text",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        // Bold segment
        Text(
            text = "Bold Segment",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        FluxText(
            segments = listOf(
                FluxTextSegment(text = "This is "),
                FluxTextSegment(text = "bold text", isBold = true),
                FluxTextSegment(text = " in a sentence.")
            ),
            style = FluxTextStyle.Body
        )

        FluxDivider()

        // Italic segment
        Text(
            text = "Italic Segment",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        FluxText(
            segments = listOf(
                FluxTextSegment(text = "This is "),
                FluxTextSegment(text = "italic text", isItalic = true),
                FluxTextSegment(text = " in a sentence.")
            ),
            style = FluxTextStyle.Body
        )

        FluxDivider()

        // Underline segment
        Text(
            text = "Underline Segment",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        FluxText(
            segments = listOf(
                FluxTextSegment(text = "This is "),
                FluxTextSegment(text = "underlined text", isUnderline = true),
                FluxTextSegment(text = " in a sentence.")
            ),
            style = FluxTextStyle.Body
        )

        FluxDivider()

        // Colored segment
        Text(
            text = "Colored Segment",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        FluxText(
            segments = listOf(
                FluxTextSegment(text = "Red ", color = Color.Red),
                FluxTextSegment(text = "Green ", color = Color(0xFF4CAF50)),
                FluxTextSegment(text = "Blue ", color = Color.Blue),
                FluxTextSegment(text = "Primary", color = colors.primary)
            ),
            style = FluxTextStyle.Body
        )

        FluxDivider()

        // Mixed attributes
        Text(
            text = "Mixed Attributes",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        FluxText(
            segments = listOf(
                FluxTextSegment(text = "Bold+Italic", isBold = true, isItalic = true),
                FluxTextSegment(text = " and "),
                FluxTextSegment(
                    text = "Colored+Underline",
                    isUnderline = true,
                    color = colors.error
                ),
                FluxTextSegment(text = " together.")
            ),
            style = FluxTextStyle.Body
        )

        FluxDivider()

        // Full combination
        Text(
            text = "Full Combination",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )
        FluxText(
            segments = listOf(
                FluxTextSegment(
                    text = "All styles combined",
                    isBold = true,
                    isItalic = true,
                    isUnderline = true,
                    color = colors.accent
                )
            ),
            style = FluxTextStyle.Title3
        )
    }
}
