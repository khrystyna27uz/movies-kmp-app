@file:OptIn(ExperimentalResourceApi::class)

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
import com.khrystynasika.movievision.movies.upcoming.UpcomingMoviesScreen
import com.khrystynasika.movievision.movies.watch.WatchMoviesScreen
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.movies_tab_upcoming
import movievision.composeapp.generated.resources.movies_tab_watch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier,
    onBrowseMoviesClicked: () -> Unit,
    onMovieDetailsClicked: (id: String) -> Unit,
) {
    val tabs = remember {
        listOf(
            Tab.Watch,
            Tab.Upcoming,
        )
    }
    var selectedTab by remember {
        mutableStateOf<Tab>(Tab.Watch)
    }

    Column(modifier = modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabs.indexOf(selectedTab)) {
            tabs.forEach { tab ->
                Tab(text = { Text(tab.title()) },
                    selected = tab == selectedTab,
                    onClick = { selectedTab = tab }
                )
            }
        }

        when (selectedTab) {
            Tab.Watch -> WatchMoviesScreen(
                onBrowseMoviesClicked = onBrowseMoviesClicked,
                onMovieDetailsClicked = onMovieDetailsClicked,
            )

            Tab.Upcoming -> UpcomingMoviesScreen(
                onBrowseMoviesClicked = onBrowseMoviesClicked,
                onMovieDetailsClicked = onMovieDetailsClicked,
            )
        }
    }
}

private sealed interface Tab {
    @Composable
    fun title(): String

    data object Watch : Tab {
        @Composable
        override fun title(): String = stringResource(resource = Res.string.movies_tab_watch)
    }

    data object Upcoming : Tab {
        @Composable
        override fun title(): String = stringResource(resource = Res.string.movies_tab_upcoming)
    }
}