package com.denisbrandi.mediumarticles.functionalmapping.domain.repository

import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import io.reactivex.Single

interface AlbumRepository {

    fun getAlbumById(id: String): Single<Result<Album>>

}