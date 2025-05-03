package com.range.fileupload.exception

import com.range.fileupload.dto.ErrorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<ErrorResponseDto> {
        return ResponseEntity(ErrorResponseDto(
            message = ex.message?:"Undefined Error",
            error = ex.localizedMessage,
            errorDescription = ex.cause.toString()
        ), HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(FileNameNotFound::class)
    fun handleFileNameNotFound(
        ex: FileNameNotFound,

    ): ResponseEntity<ErrorResponseDto> {
        val errorResponse = ErrorResponseDto(
            message = ex.message?:"Filename Not Found",
            error = ex.localizedMessage ?: "error name not found",
            errorDescription = ex.cause.toString()
        )
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }
@ExceptionHandler(FileIdNotFound::class)
fun handleFileIdNotFound(ex: FileIdNotFound): ResponseEntity<ErrorResponseDto> {
    val errorResponse = ErrorResponseDto(
        message = ex.message?:"File id not found",
        error = ex.localizedMessage?:"error name not found",
        errorDescription = ex.cause.toString()
    )
    return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
}


}