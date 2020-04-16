package com.denisbrandi.functionalmapping.data.oop.mapper

import com.denisbrandi.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.functionalmapping.domain.model.Album
import com.denisbrandi.functionalmapping.domain.model.Song

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