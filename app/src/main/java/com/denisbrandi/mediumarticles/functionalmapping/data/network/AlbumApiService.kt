package com.denisbrandi.mediumarticles.functionalmapping.data.network

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.SimpleResult
import io.reactivex.Single

interface AlbumApiService {

    fun getAlbumById(id: String): Single<SimpleResult<NetworkAlbum>>

}