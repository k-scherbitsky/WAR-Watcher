package com.scherbitsky

import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

class DeployingFile {

    fun deploy(warFile: File, tomcatFolder: String){
        val tomcat = File("$tomcatFolder\\ROOT.war")
        Files.copy(warFile.toPath(), tomcat.toPath(), StandardCopyOption.REPLACE_EXISTING)
        renderText(warFile.name, Action.DEPLOYING)
    }

}