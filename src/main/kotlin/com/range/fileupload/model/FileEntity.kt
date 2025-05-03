package com.range.fileupload.model;
import jakarta.persistence.*

@Entity
@Table(name = "files")
data class FileEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var filename: String = "",

    var size: Long? = 0,

    var contentType: String? = null,

    @Lob
    @Column(nullable = false)
    var content: ByteArray = ByteArray(0)
)
