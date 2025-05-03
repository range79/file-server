package com.range.fileupload.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.io.File

@Component
class CreateDir : CommandLineRunner{
    private val log:Logger = LoggerFactory.getLogger(CreateDir::class.java)
    override fun run(vararg args: String?) {
        //get jars directory
        val currentDir = System.getProperty("user.dir")
        val dir = File("$currentDir/db");
        if (!dir.exists()) {
            val created =  dir.mkdirs()
            if (created) {
                log.info("Created Dir")
            }
            else{
                log.error("Failed to create Dir")
            }
        }
        else{
            log.info("✅ 'db' directory already exists at: ${dir.absolutePath}")
        }
    }
}