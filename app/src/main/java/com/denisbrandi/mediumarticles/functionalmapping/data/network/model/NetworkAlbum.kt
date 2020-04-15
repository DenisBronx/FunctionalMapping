package com.denisbrandi.mediumarticles.functionalmapping.data.network.model

data class NetworkAlbum(
    val id: String?,
    val title: String?,
    val songs: List<NetworkSong>?
)