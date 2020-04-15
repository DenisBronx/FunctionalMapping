package com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Song

fun mapAlbumDto(input: NetworkAlbum, mapSongList: (List<NetworkSong>?) -> List<Song>): Album {
    return Album(
        input.id.orEmpty(),
        input.title.orEmpty(),
        mapSongList(input.songs)
    )
}