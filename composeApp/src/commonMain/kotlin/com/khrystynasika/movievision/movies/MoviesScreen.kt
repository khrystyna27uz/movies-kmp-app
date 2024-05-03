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
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import com.movievision.R
import com.khrystynasika.movievision.movies.upcoming.UpcomingMoviesScreen
import com.khrystynasika.movievision.movies.watch.WatchMoviesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier,
    onBrowseMoviesClicked: () -> Unit,
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
            )

            Tab.Upcoming -> UpcomingMoviesScreen()
        }
    }
}

private sealed interface Tab {
    @Composable
    fun title(): String

    data object Watch : Tab {
        @Composable
        override fun title(): String = "Movies"//stringResource(id = R.string.movies_tab_watch)
    }

    data object Upcoming : Tab {
        @Composable
        override fun title(): String = "Uncoming"//stringResource(id = R.string.movies_tab_upcoming)
    }
}

@Preview
@Composable
private fun PreviewMovieScreen() {
    MoviesScreen(onBrowseMoviesClicked = {})
}