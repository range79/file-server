package com.range.fileupload.dto

data class FileDownloadDto(
    val filename: String,
    val contentType: String? = null,
    val size: Long?,
    val content: ByteArray
)
