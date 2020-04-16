package com.denisbrandi.functionalmapping.data.network

import com.denisbrandi.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.functionalmapping.domain.model.SimpleResult
import io.reactivex.Single

class AlbumApiServiceImpl: AlbumApiService {
    override fun getAlbumById(id: String): Single<SimpleResult<NetworkAlbum>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}