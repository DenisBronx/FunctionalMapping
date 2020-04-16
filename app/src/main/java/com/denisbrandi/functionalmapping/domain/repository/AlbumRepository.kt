package com.denisbrandi.functionalmapping.domain.repository

import com.denisbrandi.functionalmapping.domain.model.Album
import com.denisbrandi.functionalmapping.domain.model.SimpleResult
import io.reactivex.Single

interface AlbumRepository {

    fun getAlbumById(id: String): Single<SimpleResult<Album>>

}