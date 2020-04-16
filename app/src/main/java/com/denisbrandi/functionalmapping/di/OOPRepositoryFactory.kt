package com.denisbrandi.functionalmapping.di

import com.denisbrandi.functionalmapping.data.network.AlbumApiServiceImpl
import com.denisbrandi.functionalmapping.data.oop.mapper.AlbumDataMapper
import com.denisbrandi.functionalmapping.data.oop.mapper.NullableInputListMapperImpl
import com.denisbrandi.functionalmapping.data.oop.mapper.SongDataMapper
import com.denisbrandi.functionalmapping.data.oop.repository.AlbumRepositoryImpl
import com.denisbrandi.functionalmapping.domain.repository.AlbumRepository

object OOPRepositoryFactory {

    fun makeAlbumRepository(): AlbumRepository {
        return AlbumRepositoryImpl(
            AlbumApiServiceImpl(),
            AlbumDataMapper(NullableInputListMapperImpl(SongDataMapper()))
        )
    }
}