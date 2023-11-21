package com.shobhit97.socialnetwork.presentation.edit_profile.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    modifier: Modifier = Modifier,
    onChipClick: () -> Unit = {},
    selected: Boolean = false,
    text: String,
    selectedColor :Color = MaterialTheme.colorScheme.primary,
    unselectedColor :Color = Color.LightGray
) {
    FilterChip(
        selected = selected,
        onClick = onChipClick,
        shape = CircleShape,
        label = { Text(text = text) },
        colors = FilterChipDefaults.filterChipColors(
            disabledLabelColor =unselectedColor,
            selectedLabelColor = selectedColor,
            selectedContainerColor = Color.Transparent,
        ),
        border = FilterChipDefaults.filterChipBorder(
            selectedBorderColor = selectedColor,
            disabledBorderColor = unselectedColor,
        )

    )
}