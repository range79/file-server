package com.range.fileupload.controiller

import com.range.fileupload.dto.FileDto
import com.range.fileupload.service.FileService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/file")
class FileController(private val fileService: FileService) {


    @GetMapping("/download/{id}")
    fun download(@PathVariable("id") id: Long): ResponseEntity<ByteArray> {

        val file = fileService.download(id)
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"${file.filename}\"").
            contentType(MediaType.parseMediaType(file.contentType ?: "application/octet-stream"))
            .contentLength(file.size!!)
            .body(file.content)

    }

    @GetMapping("/all")
    fun all(): ResponseEntity<List<FileDto>> {

        return ResponseEntity.ok(fileService.findAll())

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<FileDto> {

        return ResponseEntity.ok(fileService.findOneById(id))

    }
    @PostMapping("/upload")
    fun upload(@RequestBody multipartFile: MultipartFile): ResponseEntity<Any> {

        return ResponseEntity.ok(fileService.upload(multipartFile =multipartFile ));

    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        fileService.deleteFile(id)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/delete/all")
    fun deleteAll(): ResponseEntity<Any> {

        return ResponseEntity.ok(fileService.deleteAll())

    }


}