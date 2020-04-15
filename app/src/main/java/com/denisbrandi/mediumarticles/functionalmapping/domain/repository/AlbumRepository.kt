package com.denisbrandi.mediumarticles.functionalmapping.domain.repository

import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.SimpleResult
import io.reactivex.Single

interface AlbumRepository {

    fun getAlbumById(id: String): Single<SimpleResult<Album>>

}