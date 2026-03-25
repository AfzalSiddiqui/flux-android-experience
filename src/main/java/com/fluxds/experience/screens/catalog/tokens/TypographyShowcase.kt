package com.fluxds.experience.screens.catalog.tokens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography

/**
 * Showcase screen displaying all 10 typography styles from the Flux Design System.
 */
@Composable
fun TypographyShowcase() {
    val colors = FluxColors.current

    val typographyEntries = listOf(
        "largeTitle" to FluxTypography.largeTitle,
        "title1" to FluxTypography.title1,
        "title2" to FluxTypography.title2,
        "title3" to FluxTypography.title3,
        "headline" to FluxTypography.headline,
        "body" to FluxTypography.body,
        "callout" to FluxTypography.callout,
        "subheadline" to FluxTypography.subheadline,
        "footnote" to FluxTypography.footnote,
        "caption" to FluxTypography.caption
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md)
    ) {
        Text(
            text = "Typography",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(bottom = FluxSpacing.md)
        )

        Text(
            text = "All 10 typography styles from FluxTypography.",
            style = FluxTypography.body,
            color = colors.textSecondary,
            modifier = Modifier.padding(bottom = FluxSpacing.lg)
        )

        typographyEntries.forEach { (name, style) ->
            TypographyItem(
                name = name,
                style = style,
                textColor = colors.textPrimary,
                labelColor = colors.textSecondary
            )
        }
    }
}

@Composable
private fun TypographyItem(
    name: String,
    style: TextStyle,
    textColor: androidx.compose.ui.graphics.Color,
    labelColor: androidx.compose.ui.graphics.Color
) {
    Column(modifier = Modifier.padding(vertical = FluxSpacing.xs)) {
        Text(
            text = name,
            style = FluxTypography.caption,
            color = labelColor
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xxs))
        Text(
            text = "The quick brown fox jumps over the lazy dog",
            style = style,
            color = textColor
        )
        Spacer(modifier = Modifier.height(FluxSpacing.xs))
        Text(
            text = "${style.fontSize} / ${style.fontWeight} / ${style.lineHeight}",
            style = FluxTypography.caption,
            color = labelColor
        )
        Spacer(modifier = Modifier.height(FluxSpacing.sm))
    }
}
