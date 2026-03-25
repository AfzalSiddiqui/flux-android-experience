package com.fluxds.experience.screens.catalog

import androidx.compose.foundation.clickable
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
import com.fluxds.foundation.atoms.FluxDivider
import com.fluxds.foundation.molecules.FluxListRow

data class CatalogItem(val title: String, val route: String)

@Composable
fun CatalogListScreen(navController: NavController) {
    val colors = FluxColors.current

    val sections = listOf(
        "Tokens" to listOf(
            CatalogItem("Colors", "colors_showcase"),
            CatalogItem("Typography", "typography_showcase"),
            CatalogItem("Spacing", "spacing_showcase"),
            CatalogItem("Radius", "radius_showcase"),
            CatalogItem("Shadows", "shadows_showcase")
        ),
        "Atoms" to listOf(
            CatalogItem("Button", "button_showcase"),
            CatalogItem("Text", "text_showcase"),
            CatalogItem("Attributed Text", "attributed_text_showcase"),
            CatalogItem("Icon", "icon_showcase"),
            CatalogItem("Image", "image_showcase"),
            CatalogItem("Loader", "loader_showcase"),
            CatalogItem("Divider", "divider_showcase"),
            CatalogItem("CheckBox", "checkbox_showcase"),
            CatalogItem("RadioButton", "radiobutton_showcase"),
            CatalogItem("Toggle", "toggle_showcase"),
            CatalogItem("Segmented Control", "segmented_showcase"),
            CatalogItem("Shimmer", "shimmer_showcase")
        ),
        "Molecules" to listOf(
            CatalogItem("Card", "card_showcase"),
            CatalogItem("TextField", "textfield_showcase"),
            CatalogItem("ListRow", "listrow_showcase"),
            CatalogItem("AlertView", "alertview_showcase"),
            CatalogItem("InfoView", "infoview_showcase"),
            CatalogItem("OptionCard", "optioncard_showcase"),
            CatalogItem("ExpandableView", "expandable_showcase"),
            CatalogItem("FlapView", "flapview_showcase"),
            CatalogItem("CardFlap", "cardflap_showcase"),
            CatalogItem("BoxGrid", "boxgrid_showcase")
        ),
        "Organisms" to listOf(
            CatalogItem("Header", "header_showcase"),
            CatalogItem("BottomSheet", "bottomsheet_showcase"),
            CatalogItem("FormSection", "formsection_showcase"),
            CatalogItem("Graph", "graph_showcase"),
            CatalogItem("WebView", "webview_showcase")
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = FluxSpacing.md)
    ) {
        Text(
            text = "Catalog",
            style = FluxTypography.largeTitle,
            color = colors.textPrimary,
            modifier = Modifier.padding(horizontal = FluxSpacing.md, vertical = FluxSpacing.sm)
        )

        sections.forEach { (sectionTitle, items) ->
            Text(
                text = sectionTitle,
                style = FluxTypography.title3,
                color = colors.textSecondary,
                modifier = Modifier.padding(horizontal = FluxSpacing.md, vertical = FluxSpacing.xs)
            )
            items.forEach { item ->
                FluxListRow(
                    title = item.title,
                    onPress = { navController.navigate(item.route) }
                )
            }
            FluxDivider(modifier = Modifier.padding(horizontal = FluxSpacing.md))
        }
    }
}
