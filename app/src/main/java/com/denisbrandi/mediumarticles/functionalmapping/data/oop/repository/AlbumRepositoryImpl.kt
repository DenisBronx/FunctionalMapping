package com.denisbrandi.mediumarticles.functionalmapping.data.oop.repository

import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.repository.AlbumRepository
import io.reactivex.Single

class AlbumRepositoryImpl(

): AlbumRepository {

    override fun getAlbumById(id: String): Single<Result<Album>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}