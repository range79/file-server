package com.range.fileupload.service.impl

import com.range.fileupload.mapper.FileMapper
import com.range.fileupload.model.FileEntity
import com.range.fileupload.repository.FileRepository
import com.range.fileupload.service.FileService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*
import org.junit.jupiter.api.Assertions.*

class FileServiceImplTest {

    private lateinit var fileService: FileService
    private lateinit var file1 :FileEntity
    private lateinit var file2 :FileEntity
    private lateinit var fileRepository: FileRepository
    @BeforeEach
    fun setUp() {
        file1 = FileEntity(id = 1,filename = "file1.txt", content =ByteArray(1), contentType = "png", size = 32)
        file2 = FileEntity(id = 2,filename = "filxddfe1.txt", content =ByteArray(1), contentType = "png", size = 32)
        fileRepository= Mockito.mock(FileRepository::class.java)
        fileService = FileServiceImpl(fileRepository)
    }

    @Test
    fun  `find all files`() {
        Mockito.`when`(fileRepository.findAll()).thenReturn(listOf(file1, file2))
        val result = fileService.findAll()
        val filelist = listOf(file1, file2).stream().map { FileMapper.fromFileEntityToFileDto(it) }.toList()
      assertEquals(result,filelist)
    }

    @Test
    fun `should find files when uploaded`() {
        Mockito.`when`(fileRepository.findById(1)).thenReturn(Optional.of(file1))
        val result =fileService.findOneById(1)
        val file = FileMapper.fromFileEntityToFileDto(file1)
        assertEquals(file,result)

    }

    @Test
    fun deleteFile() {}

    @Test
    fun deleteAll() {}

    @Test
    fun download() {}

    @Test
    fun upload() {}
}