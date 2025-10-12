package io.github.moten07

import io.github.moten07.app.generated.resources.Res
import io.github.moten07.app.generated.resources.baseline_star_24
import io.github.moten07.app.generated.resources.baseline_menu_book_24
import io.github.moten07.app.generated.resources.round_home_24
import org.jetbrains.compose.resources.DrawableResource

sealed class NavigationItem(
    val name: String,
    val icon: DrawableResource
) {
    object Overview : NavigationItem("Overview", Res.drawable.baseline_menu_book_24)
    object Repositories : NavigationItem("Repositories", Res.drawable.round_home_24)
    object Stars : NavigationItem("Stars", Res.drawable.baseline_star_24)
    object Profile : NavigationItem("Profile", Res.drawable.round_home_24)

    companion object {
        val list = listOf(Overview, Repositories, Stars, Profile)
    }
}