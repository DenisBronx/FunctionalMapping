package com.denisbrandi.mediumarticles.functionalmapping.data.network

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import io.reactivex.Single

interface AlbumApiService {

    fun getAlbumById(id: String): Single<Result<NetworkAlbum>>

}