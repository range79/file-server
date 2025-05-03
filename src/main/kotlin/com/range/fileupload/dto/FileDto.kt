package com.range.fileupload.dto

data class FileDto(
    val id: Long,
    var filename: String,
    var size: Long? = null,
    var contentType: String? = null,


)