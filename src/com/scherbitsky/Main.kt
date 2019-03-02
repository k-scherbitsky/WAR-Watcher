package com.scherbitsky

import java.io.File
import java.util.*

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        print("Enter tomcat folder (ex. \"tomcat\\webapps\"): ")
        val tomcatFolder = readLine()

        print("Enter folder with war-file in your project(ex. \"site\\target\"): ")
        val warFolder = readLine()!!

        val fileWatcher = FileWatcher(warFolder)
        fileWatcher.watchWar()
    }
}
