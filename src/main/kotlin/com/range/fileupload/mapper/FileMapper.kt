package com.range.fileupload.mapper

import com.range.fileupload.dto.FileDownloadDto
import com.range.fileupload.dto.FileDto
import com.range.fileupload.model.FileEntity

object FileMapper {

    fun fromFileEntityToFileDto(fileEntity: FileEntity): FileDto {
        return FileDto(
            id = fileEntity.id!!,
            filename = fileEntity.filename,
            size = fileEntity.size,
            contentType = fileEntity.contentType,
        )
    }
    fun fromFileEntityToFileDownloadDto(fileEntity: FileEntity): FileDownloadDto {
        return FileDownloadDto(
            filename = fileEntity.filename,
            content = fileEntity.content,
            contentType = fileEntity.contentType,
            size = fileEntity.size

        )
    }


}