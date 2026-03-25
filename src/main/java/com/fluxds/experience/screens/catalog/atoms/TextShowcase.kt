package com.fluxds.experience.screens.catalog.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.atoms.FluxText
import com.fluxds.foundation.atoms.FluxTextStyle

@Composable
fun TextShowcase() {
    val colors = FluxColors.current

    val styles = listOf(
        "LargeTitle" to FluxTextStyle.LargeTitle,
        "Title1" to FluxTextStyle.Title1,
        "Title2" to FluxTextStyle.Title2,
        "Title3" to FluxTextStyle.Title3,
        "Headline" to FluxTextStyle.Headline,
        "Body" to FluxTextStyle.Body,
        "Callout" to FluxTextStyle.Callout,
        "Subheadline" to FluxTextStyle.Subheadline,
        "Footnote" to FluxTextStyle.Footnote,
        "Caption" to FluxTextStyle.Caption
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.sm)
    ) {
        Text(
            text = "Text",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        Text(
            text = "All Text Styles",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        styles.forEach { (label, textStyle) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = label,
                    style = FluxTypography.caption,
                    color = colors.textSecondary,
                    modifier = Modifier.weight(0.35f)
                )
                FluxText(
                    text = "The quick brown fox",
                    style = textStyle,
                    modifier = Modifier.weight(0.65f)
                )
            }
            FluxDivider()
        }
    }
}
