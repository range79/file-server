package com.range.fileupload.controiller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FileControllerView {


    @GetMapping("/")
    fun viewFileController(): String {
        return "File"
    }



}