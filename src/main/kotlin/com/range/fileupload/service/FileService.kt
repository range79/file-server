package com.range.fileupload.service

import com.range.fileupload.dto.FileDownloadDto
import com.range.fileupload.dto.FileDto
import org.springframework.web.multipart.MultipartFile

/**
 * Service interface for handling all file operations such as upload, download,
 * retrieval and deletion. This interface abstracts the persistence mechanism.
 */
interface FileService {

    /**
     * Retrieves all files stored in the database.
     *
     * @return a list of FileDto representing all stored files.
     */
    fun findAll(): List<FileDto>

    /**
     * Finds and returns a single file using its unique identifier.
     *
     * @param fileId the ID of the file to retrieve
     * @return the corresponding FileDto
     * @throws FileIdNotFound if the file is not found in the database
     */
    fun findOneById(fileId: Long): FileDto

    /**
     * Deletes a file by its ID if it exists.
     *
     * @param id the ID of the file to delete
     * @throws FileIdNotFound if the file is not found in the database
     */
    fun deleteFile(id: Long)

    /**
     * Deletes all files from the database.
     */
    fun deleteAll()

    /**
     * Retrieves a file with its binary content for download purposes.
     *
     * @param id the ID of the file to be downloaded
     * @return a FileDownloadDto containing file content and metadata
     * @throws FileIdNotFound if the file is not found
     */
    fun download(id: Long): FileDownloadDto

    /**
     * Uploads a new file to the database.
     *
     * If the file name is missing or empty, a FileNameNotFound exception is thrown.
     * If a file with the same name already exists, a unique name is generated.
     *
     * @param multipartFile the uploaded file
     * @throws FileNameNotFound if the file name is empty or null
     */
    fun upload(multipartFile: MultipartFile)
}
