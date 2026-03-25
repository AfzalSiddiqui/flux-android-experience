package com.fluxds.experience.screens.catalog.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.tokens.FluxSpacing
import com.fluxds.ds.tokens.FluxTypography
import com.fluxds.foundation.organisms.FluxWebView

@Composable
fun WebViewShowcase() {
    val colors = FluxColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(FluxSpacing.md),
        verticalArrangement = Arrangement.spacedBy(FluxSpacing.md)
    ) {
        Text(
            text = "WebView",
            style = FluxTypography.title1,
            color = colors.textPrimary
        )

        Text(
            text = "Embedded Web Content",
            style = FluxTypography.headline,
            color = colors.textSecondary
        )

        Text(
            text = "Displays a web page with a progress bar indicator while loading.",
            style = FluxTypography.footnote,
            color = colors.textSecondary
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            FluxWebView(
                url = "https://example.com",
                showProgressBar = true
            )
        }
    }
}
