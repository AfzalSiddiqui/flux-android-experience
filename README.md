# flux-android-experience

**The live showcase app for the Flux Android Design System.** See every component in action — interactive, configurable, and production-ready.

`flux-android-experience` is a native Android app built with Jetpack Compose that serves as both a **component gallery** and **developer reference**. Every Flux component has a dedicated showcase screen with live configuration options, variant previews, and real usage examples.

---

## Features

- **32 interactive showcase screens** — One for every component and token
- **Live configuration** — Toggle variants, sizes, states, and themes in real time
- **Component gallery** — Browse all Atoms, Molecules, and Organisms
- **Theme switching** — Preview components in Light, Dark, and custom themes
- **Attributed text demo** — Rich text with bold, italic, underline, colors
- **3 example flows** — Login, Dashboard, and Payment production-ready patterns
- **Design guidelines** — Do's and Don'ts for 5 categories
- **4-tab navigation** — Catalog, Examples, Guidelines, and Theme

---

## Setup

1. Open in Android Studio:
   ```
   flux-android-experience/
   ```
2. Sync Gradle and build
3. Run on **API 24+** emulator or device

The project references `flux-android-foundation`, `flux-android-assets`, and `flux-android-ds` as Gradle composite builds.

---

## Showcase Screens (32)

### Token Showcases (5)

| Screen | What It Demonstrates |
|--------|---------------------|
| ColorsShowcase | All 16 semantic color tokens with live swatches |
| TypographyShowcase | All 10 text styles from largeTitle to caption |
| SpacingShowcase | 8-step spacing scale with visual boxes |
| RadiusShowcase | 6 corner radius presets applied to surfaces |
| ShadowsShowcase | 3 shadow elevations on cards |

### Atom Showcases (12)

| Screen | Component | What It Demonstrates |
|--------|-----------|---------------------|
| ButtonShowcase | FluxButton | Primary, secondary, destructive variants; 3 sizes; loading & disabled |
| TextShowcase | FluxText | All 10 text styles |
| AttributedTextShowcase | FluxText | Bold, italic, underline, custom colors, SpanStyle segments |
| IconShowcase | FluxIcon | Material Icons; size & color options |
| ImageShowcase | FluxImage | Vector, URL sources; borders & corner radius |
| LoaderShowcase | FluxLoader | Indeterminate spinner, determinate progress bar; 3 sizes |
| DividerShowcase | FluxDivider | Horizontal & vertical; color & thickness variations |
| CheckBoxShowcase | FluxCheckBox | Filled & outlined; all sizes; animated toggle |
| RadioButtonShowcase | FluxRadioButton | Single-select groups; sizes & colors |
| ToggleShowcase | FluxToggle | Native Switch with labels; sizes & tint colors |
| SegmentedControlShowcase | FluxSegmentedControl | Filled & outlined styles; dynamic segments |
| ShimmerShowcase | FluxShimmer | Line, circle, rectangle shapes; text block & card helpers |

### Molecule Showcases (10)

| Screen | Component | What It Demonstrates |
|--------|-----------|---------------------|
| CardShowcase | FluxCard | Padding, corner radius, shadow variations |
| TextFieldShowcase | FluxTextField | Label, placeholder, secure input, error states |
| ListRowShowcase | FluxListRow | Icon, title, subtitle, chevron; tap actions |
| AlertViewShowcase | FluxAlertView | Info, success, warning, error variants; dismissible |
| InfoViewShowcase | FluxInfoView | Horizontal & vertical layouts; icon colors |
| OptionCardShowcase | FluxOptionCard | Single & multi selection; icon + label + subtitle |
| ExpandableViewShowcase | FluxExpandableView | Card, plain, bordered styles; expand/collapse |
| FlapViewShowcase | FluxFlapView | Underlined, filled, pill tab styles; icon tabs |
| CardFlapShowcase | FluxCardFlap | 3D flip animation; front & back content |
| BoxGridShowcase | FluxBoxGrid | Grid columns, selection modes, item sizes |

### Organism Showcases (5)

| Screen | Component | What It Demonstrates |
|--------|-----------|---------------------|
| HeaderShowcase | FluxHeader | Title, subtitle, leading/trailing actions |
| BottomSheetShowcase | FluxBottomSheet | Small, medium, large detents; drag-to-dismiss |
| FormSectionShowcase | FluxFormSection | Grouped form fields with section titles |
| GraphShowcase | FluxGraph | Bar, line, pie charts; animated data visualization |
| WebViewShowcase | FluxWebView | URL loading, progress bar, error handling |

### Example Flows (3)

| Screen | What It Demonstrates |
|--------|---------------------|
| LoginFlowExample | Email/password form, validation, alerts, loading states |
| DashboardFlowExample | Cards, graphs, list rows, info views in a dashboard layout |
| PaymentFlowExample | Amount input, option cards, confirmation, success alert |

### Guidelines & Theme (2)

| Screen | What It Demonstrates |
|--------|---------------------|
| DosAndDontsScreen | Do's and Don'ts for colors, typography, spacing, components, accessibility |
| ThemeSettingsScreen | Color scheme picker, brand picker, live color preview swatches |

---

## App Structure

```
flux-android-experience/
|-- settings.gradle.kts
|-- build.gradle.kts
|-- gradle.properties
|-- LICENSE
|-- README.md
+-- src/main/
    |-- AndroidManifest.xml
    |-- res/values/themes.xml
    +-- java/com/fluxds/experience/
        |-- MainActivity.kt
        |-- navigation/
        |   +-- FluxExperienceApp.kt          (4-tab BottomNavigation + NavHost)
        |-- screens/catalog/
        |   |-- CatalogListScreen.kt           (section list: Tokens/Atoms/Molecules/Organisms)
        |   |-- tokens/
        |   |   |-- ColorsShowcase.kt
        |   |   |-- TypographyShowcase.kt
        |   |   |-- SpacingShowcase.kt
        |   |   |-- RadiusShowcase.kt
        |   |   +-- ShadowsShowcase.kt
        |   |-- atoms/
        |   |   |-- ButtonShowcase.kt
        |   |   |-- TextShowcase.kt
        |   |   |-- AttributedTextShowcase.kt
        |   |   |-- IconShowcase.kt
        |   |   |-- ImageShowcase.kt
        |   |   |-- LoaderShowcase.kt
        |   |   |-- DividerShowcase.kt
        |   |   |-- CheckBoxShowcase.kt
        |   |   |-- RadioButtonShowcase.kt
        |   |   |-- ToggleShowcase.kt
        |   |   |-- SegmentedControlShowcase.kt
        |   |   +-- ShimmerShowcase.kt
        |   |-- molecules/
        |   |   |-- CardShowcase.kt
        |   |   |-- TextFieldShowcase.kt
        |   |   |-- ListRowShowcase.kt
        |   |   |-- AlertViewShowcase.kt
        |   |   |-- InfoViewShowcase.kt
        |   |   |-- OptionCardShowcase.kt
        |   |   |-- ExpandableViewShowcase.kt
        |   |   |-- FlapViewShowcase.kt
        |   |   |-- CardFlapShowcase.kt
        |   |   +-- BoxGridShowcase.kt
        |   +-- organisms/
        |       |-- HeaderShowcase.kt
        |       |-- BottomSheetShowcase.kt
        |       |-- FormSectionShowcase.kt
        |       |-- GraphShowcase.kt
        |       +-- WebViewShowcase.kt
        |-- screens/examples/
        |   |-- ExamplesListScreen.kt
        |   |-- LoginFlowExample.kt
        |   |-- DashboardFlowExample.kt
        |   +-- PaymentFlowExample.kt
        |-- screens/guidelines/
        |   +-- DosAndDontsScreen.kt
        +-- screens/theme/
            +-- ThemeSettingsScreen.kt
```

---

## Dependencies

| Package | Purpose |
|---------|---------|
| [flux-android-foundation](../flux-android-foundation) | All UI components + design tokens |
| [flux-android-assets](../flux-android-assets) | Strings, images, and localized resources |
| [flux-android-ds](../flux-android-ds) | Design tokens (included via foundation) |
| Compose Navigation | Screen routing and 4-tab bottom navigation |
| Material 3 | Base UI layer with custom FluxTheme on top |

---

## License

MIT License - Copyright (c) 2026 Afzal Siddiqui
