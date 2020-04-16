package com.denisbrandi.functionalmapping.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkAlbum(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("songs")
    val songs: List<NetworkSong>?
)