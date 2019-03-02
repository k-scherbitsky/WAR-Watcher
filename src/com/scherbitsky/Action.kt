package com.scherbitsky

import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchEvent

enum class Action {
    ENTRY_MODIFY,
    ENTRY_CREATE,
    ENTRY_DELETE,
    DEPLOYING,
    ERROR;

    companion object {
        fun getAction(kind: WatchEvent.Kind<out Any>?): Action = when (kind) {
            StandardWatchEventKinds.ENTRY_MODIFY -> ENTRY_MODIFY
            StandardWatchEventKinds.ENTRY_CREATE -> ENTRY_CREATE
            StandardWatchEventKinds.ENTRY_DELETE -> ENTRY_DELETE
            else -> ERROR
        }
    }

}