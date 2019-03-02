package com.scherbitsky

import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchEvent
import java.text.SimpleDateFormat
import java.util.*

val currentDate: String?
    get() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        return sdf.format(Date())
    }

fun renderText(fileName: String, action: Action): String = when (action) {
    Action.ENTRY_MODIFY -> "$currentDate - WAR file '$fileName' was modified"
    Action.ENTRY_CREATE -> "$currentDate - WAR file '$fileName' was created"
    Action.ENTRY_DELETE -> "$currentDate - WAR file '$fileName' was deleted"
    Action.DEPLOYING -> "$currentDate - WAR file '$fileName' was deployed"
    Action.ERROR -> "$currentDate - Error!"
}