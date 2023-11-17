package com.shobhit97.socialnetwork.domain.models

import com.shobhit97.socialnetwork.domain.util.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedString: String
)
