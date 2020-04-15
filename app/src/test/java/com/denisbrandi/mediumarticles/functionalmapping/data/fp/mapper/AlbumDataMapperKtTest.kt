package com.denisbrandi.mediumarticles.functionalmapping.data.fp.mapper

import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.mediumarticles.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.mediumarticles.functionalmapping.domain.model.Song
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AlbumDataMapperKtTest {

    private val networkSongList = emptyList<NetworkSong>()
    private val songList = emptyList<Song>()
    private val mapSongList: (List<NetworkSong>?) -> List<Song> = {
        if (it === networkSongList) songList else throw Exception("not mocked")
    }

    private fun makeNetworkAlbum(
        id: String? = null,
        title: String? = null
    ): NetworkAlbum {
        return NetworkAlbum(id, title, networkSongList)
    }

    @Test
    fun `mapAlbumDto should replace null values with defaults`() {
        val dto = makeNetworkAlbum()

        val actual = mapAlbumDto(dto, mapSongList)

        assertThat(actual.id).isEmpty()
        assertThat(actual.title).isEmpty()
    }

    @Test
    fun `mapAlbumDto should assign correct values`() {
        val dto = makeNetworkAlbum("id", "title")

        val actual = mapAlbumDto(dto, mapSongList)

        assertThat(actual.id).isEqualTo("id")
        assertThat(actual.title).isEqualTo("title")
        assertThat(actual.songs).isEqualTo(songList)
    }
}