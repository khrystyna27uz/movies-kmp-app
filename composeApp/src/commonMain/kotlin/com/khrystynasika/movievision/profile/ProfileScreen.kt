package com.khrystynasika.movievision.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khrystynasika.movievision.core.koinViewModel

@Composable
fun ProfileScreen() {

    val viewModel: ProfileViewModel = koinViewModel()

    ProfileView(
        onOptionSelected1 = viewModel::onOptionSelected,
    )
}

@Composable
private fun ProfileView(
    onOptionSelected1: (String) -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight(),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 100.dp)
                .background(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = CircleShape,
                )
                .size(190.dp)
        ) {
            Icon(
                modifier = Modifier.size(120.dp),
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                imageVector = Icons.Filled.Person,
                contentDescription = null
            )
        }

        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 38.sp,
            fontWeight = FontWeight.Medium,
            text = "Hello, user!"
        )

        HorizontalDivider()

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .align(alignment = Alignment.Start),
            text = "Appearance"
        )

        val radioOptions = ThemeOptions.entries.map { it.text }
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
        Column {
            radioOptions.forEach { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected1(text)
                                onOptionSelected(text)
                            }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected1(text)
                            onOptionSelected(text)
                        }
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

    }
}