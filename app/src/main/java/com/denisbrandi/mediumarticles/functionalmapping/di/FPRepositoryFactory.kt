package com.denisbrandi.mediumarticles.functionalmapping.di

import com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper.mapAlbumDto
import com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper.mapNullInputList
import com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper.mapSongDto
import com.denisbrandi.mediumarticles.functionalmapping.data.fp.repository.AlbumRepositoryImpl
import com.denisbrandi.mediumarticles.functionalmapping.data.network.AlbumApiServiceImpl
import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.repository.AlbumRepository

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