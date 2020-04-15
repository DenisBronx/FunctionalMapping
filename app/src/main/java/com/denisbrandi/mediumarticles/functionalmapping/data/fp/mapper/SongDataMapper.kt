package com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Song
import java.text.SimpleDateFormat

fun mapSongDto(input: NetworkSong, formatDate: (String?) -> Long = { formatAlbumDate(it) }): Song {
    return Song(
        input.id.orEmpty(),
        input.name.orEmpty(),
        input.link.orEmpty(),
        input.duration ?: 0,
        input.metadata?.let {
            Song.Metadata(
                formatDate(it.creationDate),
                formatDate(it.uploadDate),
                it.authorFullName.orEmpty()
            )
        } ?: Song.Metadata(0, 0, "")
    )
}

private fun formatAlbumDate(date: String?): Long {
    return date?.let {
        SimpleDateFormat("dd MMMM yyyy HH:mm:ss").parse(it).time
    } ?: Long.MIN_VALUE
}