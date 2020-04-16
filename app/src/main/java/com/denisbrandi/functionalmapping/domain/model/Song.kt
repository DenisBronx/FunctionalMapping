package com.denisbrandi.functionalmapping.domain.model

// Entity
data class Song(
    val id: String,
    val name: String,
    val link: String,
    val duration: Long,
    val metadata: Metadata
) {
    // Value Object
    data class Metadata(
        val creationDate: Long,
        val uploadDate: Long,
        val authorFullName: String
    )
}