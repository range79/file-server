package com.range.fileupload.service.impl

import com.range.fileupload.dto.FileDownloadDto
import com.range.fileupload.dto.FileDto
import com.range.fileupload.exception.FileIdNotFound
import com.range.fileupload.exception.FileNameNotFound
import com.range.fileupload.mapper.FileMapper
import com.range.fileupload.model.FileEntity
import com.range.fileupload.repository.FileRepository
import com.range.fileupload.service.FileService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.FileNotFoundException

@Service
class FileServiceImpl(private val fileRepository: FileRepository):FileService {

    override fun findAll(): List<FileDto> {

        val files = fileRepository.findAll().stream().map{
            FileMapper.fromFileEntityToFileDto(it) }
        return files.toList()

    }

    override fun findOneById(fileId: Long): FileDto {

        val fileEntity = FileMapper
            .fromFileEntityToFileDto(fileRepository.findById(fileId)
                .orElseThrow{FileIdNotFound("File id not found! ${fileId}")})
        return fileEntity

    }

    override fun deleteFile(id: Long) {
     val file = fileRepository.existsById(id)
        if (file){
            return fileRepository.deleteById(id)
        }
        else{
            throw FileIdNotFound("File not found! ${id}")

        }


    }

    override fun deleteAll() {
        return fileRepository.deleteAll()
    }

    override fun download(id: Long): FileDownloadDto {
        //convert to FileDownloadEntity
        return FileMapper.fromFileEntityToFileDownloadDto(fileRepository
            .findById(id)
            //if not found with id throw an exception
            .orElseThrow{RuntimeException("File not found! ${id}")})
    }

    override fun upload(multipartFile: MultipartFile) {
        val file = FileEntity(
            filename = multipartFile.originalFilename ?:"unnamed file",
            size = multipartFile.size,
            contentType = multipartFile.contentType,
            content = multipartFile.bytes
        )


        if (file.filename.isEmpty()) {
            throw FileNameNotFound("invalid or empty file!")
        }
        // if a file in file repo
        if (fileRepository.existsByFilename(file.filename)) {
            file.filename = generateUniqueFilename(file.filename){
                fileRepository.existsByFilename(it)
            }
        }
        fileRepository.save(file)

    }
  private fun generateUniqueFilename(originalFilename: String, exists: (String) -> Boolean): String {
        val dotIndex = originalFilename.lastIndexOf(".")
        val name = if (dotIndex != -1) originalFilename.substring(0, dotIndex) else originalFilename
        val extension = if (dotIndex != -1) originalFilename.substring(dotIndex) else ""

        var newName = originalFilename
        var counter = 1

        while (exists(newName)) {
            newName = "$name ($counter)$extension"
            counter++
        }

        return newName
    }

}
