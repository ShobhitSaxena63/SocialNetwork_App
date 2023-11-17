package com.shobhit97.socialnetwork.domain.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateFormatUtil {
    fun timeStampToFormattedString(timeStamp:Long, pattern:String):String {
        return SimpleDateFormat(pattern, Locale.getDefault()).run {
            format(timeStamp)
        }
    }
}