package com.denisbrandi.functionalmapping.data.fp.mapper

import com.denisbrandi.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.functionalmapping.domain.model.Album
import com.denisbrandi.functionalmapping.domain.model.Song

fun mapAlbumDto(input: NetworkAlbum, mapSongList: (List<NetworkSong>?) -> List<Song>): Album {
    return Album(
        input.id.orEmpty(),
        input.title.orEmpty(),
        mapSongList(input.songs)
    )
}