package com.range.fileupload.dto

import java.time.LocalDateTime

data class ErrorResponseDto (
    val message: String,
    val error: String,
    val errorDescription: String,
    val timestamp: LocalDateTime=LocalDateTime.now()
)
