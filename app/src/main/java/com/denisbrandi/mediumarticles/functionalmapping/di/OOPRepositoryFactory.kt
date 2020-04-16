package com.denisbrandi.mediumarticles.functionalmapping.di

import com.denisbrandi.mediumarticles.functionalmapping.data.network.AlbumApiServiceImpl
import com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper.AlbumDataMapper
import com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper.NullableInputListMapperImpl
import com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper.SongDataMapper
import com.denisbrandi.mediumarticles.functionalmapping.data.oop.repository.AlbumRepositoryImpl
import com.denisbrandi.mediumarticles.functionalmapping.domain.repository.AlbumRepository

object OOPRepositoryFactory {

    fun makeAlbumRepository(): AlbumRepository {
        return AlbumRepositoryImpl(
            AlbumApiServiceImpl(),
            AlbumDataMapper(NullableInputListMapperImpl(SongDataMapper()))
        )
    }
}