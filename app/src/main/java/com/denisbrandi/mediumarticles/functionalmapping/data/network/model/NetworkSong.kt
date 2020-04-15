package com.denisbrandi.mediumarticles.functionalmapping.data.network.model

data class NetworkSong(
    val id: String?,
    val name: String?,
    val link: String?,
    val duration: Long?,
    val metadata: NetworkMetadata?
) {
    data class NetworkMetadata(
        val creationDate: String?,
        val uploadDate: String?,
        val authorFullName: String?
    )
}