package com.range.fileupload.repository

import com.range.fileupload.model.FileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FileRepository:JpaRepository<FileEntity, Long> {
    fun existsByFilename(filename: String): Boolean
    fun deleteByFilename(filename: String)
}