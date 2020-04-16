package com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Song
import java.text.SimpleDateFormat

fun mapSongDto(input: NetworkSong): Song {
    return Song(
        input.id.orEmpty(),
        input.name.orEmpty(),
        input.link.orEmpty(),
        input.duration ?: 0,
        Song.Metadata(
            formatAlbumDate(input.creationDate),
            formatAlbumDate(input.uploadDate),
            input.authorFullName.orEmpty()
        )
    )
}

private fun formatAlbumDate(date: String?): Long {
    return date?.let {
        SimpleDateFormat("dd MMMM yyyy HH:mm:ss").parse(it).time
    } ?: Long.MIN_VALUE
}