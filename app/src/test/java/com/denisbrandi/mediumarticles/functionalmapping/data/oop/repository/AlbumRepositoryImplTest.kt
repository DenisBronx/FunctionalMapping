package com.denisbrandi.mediumarticles.functionalmapping.data.oop.repository

import com.denisbrandi.mediumarticles.functionalmapping.data.network.AlbumApiService
import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper.Mapper
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Album
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Result
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class AlbumRepositoryImplTest {

    private val albumApiService: AlbumApiService = mock()
    private val albumDataMapper: Mapper<NetworkAlbum, Album> = mock()
    private val sut = AlbumRepositoryImpl(albumApiService, albumDataMapper)

    @Test
    fun `getAlbumById should return album when apiService call is successful`() {
        val networkAlbum = NetworkAlbum(null, null, emptyList())
        val album = Album("", "", emptyList())
        whenever(albumApiService.getAlbumById(ALBUM_ID))
            .thenReturn(Single.just(Result.Success(networkAlbum)))
        whenever(albumDataMapper.map(networkAlbum)).thenReturn(album)

        val testObserver = sut.getAlbumById(ALBUM_ID).test()

        testObserver.assertValue(Result.Success(album))
    }

    @Test
    fun `getAlbumById should return unmapped Failure when apiService call is not successful`() {
        val throwable = Throwable()
        whenever(albumApiService.getAlbumById(ALBUM_ID))
            .thenReturn(Single.just(Result.Failure(throwable)))

        val testObserver = sut.getAlbumById(ALBUM_ID).test()

        testObserver.assertValue(Result.Failure(throwable))
    }

    private companion object {
        const val ALBUM_ID = "id"
    }
}