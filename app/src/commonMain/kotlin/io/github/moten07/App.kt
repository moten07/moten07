package io.github.moten07

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val viewModel: MainViewModel = viewModel { MainViewModel() }

    val items = NavigationItem.list
    val selected = remember { mutableIntStateOf(0) }

    AppTheme(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selected.value == index,
                        onClick = { selected.value = index },
                        icon = {
                            Icon(
                                painter = painterResource(resource = item.icon),
                                contentDescription = item.name
                            )
                        },
                        label = { Text(text = item.name) }
                    )
                }

            }
        }
    ) {

    }
}