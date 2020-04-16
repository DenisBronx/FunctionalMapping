package com.denisbrandi.functionalmapping.data.network

import com.denisbrandi.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.functionalmapping.domain.model.SimpleResult
import io.reactivex.Single

interface AlbumApiService {

    fun getAlbumById(id: String): Single<SimpleResult<NetworkAlbum>>

}