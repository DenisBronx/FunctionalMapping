package com.denisbrandi.functionalmapping.di

import com.denisbrandi.functionalmapping.data.fp.mapper.mapAlbumDto
import com.denisbrandi.functionalmapping.data.fp.mapper.mapNullInputList
import com.denisbrandi.functionalmapping.data.fp.mapper.mapSongDto
import com.denisbrandi.functionalmapping.data.fp.repository.AlbumRepositoryImpl
import com.denisbrandi.functionalmapping.data.network.AlbumApiServiceImpl
import com.denisbrandi.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.functionalmapping.domain.model.Album
import com.denisbrandi.functionalmapping.domain.repository.AlbumRepository

object FPRepositoryFactory {

    fun makeAlbumRepository(): AlbumRepository {
        return AlbumRepositoryImpl(
            AlbumApiServiceImpl(),
            makeAlbumDataMapper()
        )
    }

    private fun makeAlbumDataMapper(): (NetworkAlbum) -> Album = { albumDto ->
        mapAlbumDto(albumDto) { listItemDto ->
            mapNullInputList(listItemDto) { songDto ->
                mapSongDto(songDto)
            }
        }
    }

}