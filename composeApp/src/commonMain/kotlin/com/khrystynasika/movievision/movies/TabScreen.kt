@file:Suppress("RemoveExplicitTypeArguments")

package com.khrystynasika.movievision.movies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun TabScreen(
    modifier: Modifier = Modifier,
    tabs: List<MovieTab>,
) {
    var selectedTabIndex by remember {
        mutableStateOf<Int>(0)
    }
    var selectedTab by remember {
        mutableStateOf<MovieTab>(tabs.first())
    }

    Column(modifier = modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, _ ->
                Tab(text = { Text(text = tabs[index].title) },
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                        selectedTab = tabs[index]
                    }
                )
            }
        }

        selectedTab.content()
    }
}

data class MovieTab(
    val title: String,
    val content: @Composable () -> Unit,
)