package com.chillrate.navigation.bottom_navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.chillrate.navigation.core.NavProvider
import com.chillrate.ui.theme.SHUITheme.palettes

abstract class NavItem(
    val name: String,
    val icon: ImageVector,
    val provider: NavProvider
) {
    abstract fun selected(destination: NavDestination): Boolean
}

inline fun <reified P : NavProvider> navItem(
    name: String,
    icon: ImageVector,
    provider: P
) = object : NavItem(name, icon, provider) {
    override fun selected(destination: NavDestination) = destination.hasRoute<P>()
}

@Composable
fun RowScope.NavigationItem(
    item: NavItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    val accentColor = if (selected) palettes.primary else palettes.mutedForeground

    NavigationBarItem(
        selected = selected,
        onClick = { if (!selected) onClick() },
        label = { Text(text = item.name, color = accentColor) },
        icon = { Icon(item.icon, contentDescription = null, tint = accentColor) },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = accentColor.copy(alpha = 0.4f)
        )
    )
}