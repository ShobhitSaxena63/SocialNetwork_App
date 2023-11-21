package com.shobhit97.socialnetwork.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class ProfileViewModel @Inject constructor() : ViewModel() {
    private val _toolbarOffsetY = mutableFloatStateOf(0f)
    val toolbarOffsetY: State<Float> = _toolbarOffsetY

    private val _expandedRatio = mutableFloatStateOf(1f)
    val expandedRatio: State<Float> = _expandedRatio

    fun setToolbarOffsetY(value:Float){
        _toolbarOffsetY.value = value
    }
    fun setExpandedRatio(ratio:Float){
        _expandedRatio.value = ratio
    }

}