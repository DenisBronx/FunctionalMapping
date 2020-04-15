package com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album

fun map(input: NetworkAlbum): Album {
    return Album(
        input.id.orEmpty(),
        input.title.orEmpty(),
        songListDataMapper.map(input.songs)
    )
}