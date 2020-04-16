package com.denisbrandi.functionalmapping.data.fp.mapper

import com.denisbrandi.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.functionalmapping.domain.model.Song
import java.text.SimpleDateFormat
import java.util.*

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
        SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.UK).parse(it).time
    } ?: Long.MIN_VALUE
}