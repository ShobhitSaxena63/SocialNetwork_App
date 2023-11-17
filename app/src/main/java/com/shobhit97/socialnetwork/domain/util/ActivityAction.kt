package com.shobhit97.socialnetwork.domain.util

sealed class ActivityAction {
    object LikedPost:ActivityAction()
    object CommentedPost:ActivityAction()


}
