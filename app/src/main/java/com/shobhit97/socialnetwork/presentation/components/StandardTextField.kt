package com.shobhit97.socialnetwork.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shobhit97.socialnetwork.R
import com.shobhit97.socialnetwork.presentation.util.TestTags.PASSWORD_TOGGLE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 20,
    error: String = "",
    leadingIcon: ImageVector? = null,
    shape: Shape = TextFieldDefaults.filledShape,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    singleLine:Boolean = true,
    maxLines:Int = 3,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    onValueChange: (String) -> Unit,

    ) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) onValueChange(it)
            },
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            colors = colors,
            shape = shape,
            isError = error != "",
            visualTransformation = if (!showPasswordToggle && isPasswordToggleDisplayed) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            maxLines = maxLines,
            singleLine = singleLine,
            leadingIcon = if (leadingIcon != null) {
                val icon:@Composable () -> Unit = {
                    Icon(
                        imageVector = leadingIcon, contentDescription = "null",
                        tint = Color.White,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = if (isPasswordToggleDisplayed) {
                val icon:@Composable () -> Unit = {

                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!showPasswordToggle)
                        },
                        modifier = Modifier.testTag(PASSWORD_TOGGLE)
                    ) {
                        Icon(
                            imageVector = if (showPasswordToggle) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = if (showPasswordToggle) stringResource(id = R.string.password_visible_content_description)
                            else stringResource(
                                id = R.string.password_hidden_content_description
                            )
                        )
                    }
                }
                icon
            } else null
            ,

            modifier = modifier.fillMaxWidth()
        )

        if (error.isNotEmpty()) {
            Text(
                text = error, style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}