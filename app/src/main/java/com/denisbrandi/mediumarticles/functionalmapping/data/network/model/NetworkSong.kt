package com.denisbrandi.mediumarticles.functionalmapping.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkSong(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("duration")
    val duration: Long?,
    @SerializedName("creationDate")
    val creationDate: String?,
    @SerializedName("uploadDate")
    val uploadDate: String?,
    @SerializedName("authorFullName")
    val authorFullName: String?
)