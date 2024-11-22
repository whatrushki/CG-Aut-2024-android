package com.chillrate.ui.components.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.theme.SHUIShapes
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.spacing
import app.whatrushik.what_shadcn_ui.core.react.useState

@Composable
fun SearchWidget(
    modifier: Modifier = Modifier,
    categories: List<String>,
    onSearch: (String) -> Unit,
    selected: Int,
    onSelectCategory: (Int) -> Unit
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .clip(SHUIShapes.Medium)
        .background(palettes.background)
        .padding(spacing.md.dp)
) {
    Column {
        val (value, setValue) = useState("")

        SearchBar(
            value,
            setValue,
            onSearch
        )

        Space(spacing.md)

        FilterBadge(
            categories,
            selected,
            onSelectCategory
        )
    }
}