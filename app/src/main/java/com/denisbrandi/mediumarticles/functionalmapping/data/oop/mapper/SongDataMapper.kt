package com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Song
import java.text.SimpleDateFormat
import java.util.*

class SongDataMapper : Mapper<NetworkSong, Song> {

    override fun map(input: NetworkSong): Song {
        return Song(
            input.id.orEmpty(),
            input.name.orEmpty(),
            input.link.orEmpty(),
            input.duration ?: 0,
            Song.Metadata(
                formatDate(input.creationDate),
                formatDate(input.uploadDate),
                input.authorFullName.orEmpty()
            )
        )
    }

    private fun formatDate(date: String?): Long {
        return date?.let {
            SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.UK).parse(it).time
        } ?: Long.MIN_VALUE
    }

    private companion object {
        const val DATE_FORMAT_PATTERN = "dd MMMM yyyy HH:mm:ss"
    }

}