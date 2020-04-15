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
            input.metadata?.let {
                Song.Metadata(
                    formatDate(it.creationDate),
                    formatDate(it.uploadDate),
                    it.authorFullName.orEmpty()
                )
            } ?: Song.Metadata(0, 0, "")
        )
    }

    private fun formatDate(date: String?): Long {
        return date?.let {
            SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault()).parse(it).time
        } ?: Long.MIN_VALUE
    }

    private companion object {
        const val DATE_FORMAT_PATTERN = "dd MMMM yyyy HH:mm:ss"
    }

}