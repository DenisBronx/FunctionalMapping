package com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Song

class AlbumDataMapper(
    private val songListDataMapper: NullableInputListMapper<NetworkSong, Song>
) : Mapper<NetworkAlbum, Album> {

    override fun map(input: NetworkAlbum): Album {
        return Album(
            input.id.orEmpty(),
            input.title.orEmpty(),
            songListDataMapper.map(input.songs)
        )
    }

}