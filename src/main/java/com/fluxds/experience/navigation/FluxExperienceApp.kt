package com.fluxds.experience.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fluxds.ds.theme.FluxColors
import com.fluxds.ds.theme.FluxThemeState
import com.fluxds.experience.screens.catalog.*
import com.fluxds.experience.screens.catalog.atoms.*
import com.fluxds.experience.screens.catalog.molecules.*
import com.fluxds.experience.screens.catalog.organisms.*
import com.fluxds.experience.screens.catalog.tokens.*
import com.fluxds.experience.screens.examples.*
import com.fluxds.experience.screens.guidelines.DosAndDontsScreen
import com.fluxds.experience.screens.theme.ThemeSettingsScreen

sealed class BottomTab(val route: String, val label: String, val icon: ImageVector) {
    data object Catalog : BottomTab("catalog", "Catalog", Icons.Filled.Layers)
    data object Examples : BottomTab("examples", "Examples", Icons.Filled.PlayArrow)
    data object Guidelines : BottomTab("guidelines", "Guidelines", Icons.Filled.Checklist)
    data object Theme : BottomTab("theme", "Theme", Icons.Filled.ColorLens)
}

@Composable
fun FluxExperienceApp(themeState: FluxThemeState) {
    val navController = rememberNavController()
    val tabs = listOf(BottomTab.Catalog, BottomTab.Examples, BottomTab.Guidelines, BottomTab.Theme)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val colors = FluxColors.current

    Scaffold(
        containerColor = colors.background,
        bottomBar = {
            NavigationBar(containerColor = colors.surface) {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute?.startsWith(tab.route) == true,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colors.primary,
                            selectedTextColor = colors.primary,
                            unselectedIconColor = colors.textSecondary,
                            unselectedTextColor = colors.textSecondary
                        )
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "catalog",
            modifier = Modifier.padding(padding)
        ) {
            // Catalog tab
            composable("catalog") { CatalogListScreen(navController) }
            // Token showcases
            composable("colors_showcase") { ColorsShowcase() }
            composable("typography_showcase") { TypographyShowcase() }
            composable("spacing_showcase") { SpacingShowcase() }
            composable("radius_showcase") { RadiusShowcase() }
            composable("shadows_showcase") { ShadowsShowcase() }
            // Atom showcases
            composable("button_showcase") { ButtonShowcase() }
            composable("text_showcase") { TextShowcase() }
            composable("attributed_text_showcase") { AttributedTextShowcase() }
            composable("icon_showcase") { IconShowcase() }
            composable("image_showcase") { ImageShowcase() }
            composable("loader_showcase") { LoaderShowcase() }
            composable("divider_showcase") { DividerShowcase() }
            composable("checkbox_showcase") { CheckBoxShowcase() }
            composable("radiobutton_showcase") { RadioButtonShowcase() }
            composable("toggle_showcase") { ToggleShowcase() }
            composable("segmented_showcase") { SegmentedControlShowcase() }
            composable("shimmer_showcase") { ShimmerShowcase() }
            // Molecule showcases
            composable("card_showcase") { CardShowcase() }
            composable("textfield_showcase") { TextFieldShowcase() }
            composable("listrow_showcase") { ListRowShowcase() }
            composable("alertview_showcase") { AlertViewShowcase() }
            composable("infoview_showcase") { InfoViewShowcase() }
            composable("optioncard_showcase") { OptionCardShowcase() }
            composable("expandable_showcase") { ExpandableViewShowcase() }
            composable("flapview_showcase") { FlapViewShowcase() }
            composable("cardflap_showcase") { CardFlapShowcase() }
            composable("boxgrid_showcase") { BoxGridShowcase() }
            // Organism showcases
            composable("header_showcase") { HeaderShowcase() }
            composable("bottomsheet_showcase") { BottomSheetShowcase() }
            composable("formsection_showcase") { FormSectionShowcase() }
            composable("graph_showcase") { GraphShowcase() }
            composable("webview_showcase") { WebViewShowcase() }
            // Examples tab
            composable("examples") { ExamplesListScreen(navController) }
            composable("login_flow") { LoginFlowExample() }
            composable("dashboard_flow") { DashboardFlowExample() }
            composable("payment_flow") { PaymentFlowExample() }
            // Guidelines tab
            composable("guidelines") { DosAndDontsScreen() }
            // Theme tab
            composable("theme") { ThemeSettingsScreen(themeState) }
        }
    }
}
