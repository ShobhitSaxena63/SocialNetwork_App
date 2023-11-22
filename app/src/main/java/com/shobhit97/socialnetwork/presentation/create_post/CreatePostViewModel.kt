package com.shobhit97.socialnetwork.presentation.create_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shobhit97.socialnetwork.presentation.util.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class CreatePostViewModel @Inject constructor(
    
) : ViewModel() {
    private val _descriptionState = mutableStateOf<StandardTextFieldState>(StandardTextFieldState())
    val descriptionState: State<StandardTextFieldState> = _descriptionState

    fun setDescriptionState(state:StandardTextFieldState) {
        _descriptionState.value = state
    }
}