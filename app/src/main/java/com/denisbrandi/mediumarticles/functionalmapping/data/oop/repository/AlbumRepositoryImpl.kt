package com.denisbrandi.mediumarticles.functionalmapping.data.oop.repository

import com.denisbrandi.mediumarticles.functionalmapping.data.network.AlbumApiService
import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper.Mapper
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Result
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.SimpleResult
import com.denisbrandi.mediumarticles.functionalmapping.domain.repository.AlbumRepository
import io.reactivex.Single

class AlbumRepositoryImpl(
    private val albumApiService: AlbumApiService,
    private val albumDataMapper: Mapper<NetworkAlbum, Album>
) : AlbumRepository {

    override fun getAlbumById(id: String): Single<SimpleResult<Album>> {
        return albumApiService.getAlbumById(id).map {
            it.fold(
                success = { dto -> Result.Success(albumDataMapper.map(dto)) },
                failure = { throwable -> Result.Failure(throwable) }
            )
        }
    }

}