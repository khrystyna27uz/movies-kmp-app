package com.khrystynasika.movievision.profile

import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    fun onOptionSelected(selected: String) {

        when (selected) {
            ThemeOptions.SYSTEM_DEFAULT.name -> {}
            ThemeOptions.LIGHT.name -> {}
            ThemeOptions.DARK.name -> {}
        }
    }

}

enum class ThemeOptions(val text: String) {
    SYSTEM_DEFAULT("System default"),
    LIGHT("Light"),
    DARK("Dark"),
}