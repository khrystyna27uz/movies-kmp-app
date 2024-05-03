package com.khrystynasika.movievision

sealed class NavigationDestination(val route: String) {
    data object Home : NavigationDestination("home")
    data object BrowseAll : NavigationDestination("browse_all")
}