package com.scherbitsky

import java.io.File
import java.io.FileWriter
import java.nio.file.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

class FileWatcher (private val warDir: String){


    fun watchWar() {
        val filePath = Paths.get(warDir)
        val watchService = FileSystems.getDefault().newWatchService()
        filePath.register(watchService,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE)

        while (true) {
            val watchKey = watchService.take()

            for (event in watchKey.pollEvents()) {
                val kind = event.kind()

                val fileName = event.context().toString()
                if (isWarFile(fileName)) {
                    println(renderText(fileName, Action.getAction(kind)))
                }
            }
            watchKey.reset()
        }
    }

    private fun isWarFile(fileName: String): Boolean {
        val pattern = Pattern.compile("^\\w+.war$")
        return pattern.matcher(fileName).matches()
    }


}