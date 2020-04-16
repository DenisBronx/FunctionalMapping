package com.denisbrandi.functionalmapping.data.oop.mapper

import com.denisbrandi.functionalmapping.data.network.model.NetworkAlbum
import com.denisbrandi.functionalmapping.data.network.model.NetworkSong
import com.denisbrandi.functionalmapping.domain.model.Song
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

class AlbumDataMapperTest {

    private val networkSongList = emptyList<NetworkSong>()
    private val songList = emptyList<Song>()
    private val songListDataMapper: NullableInputListMapper<NetworkSong, Song> = mock {
        whenever(it.map(networkSongList)).thenReturn(songList)
    }
    private val sut = AlbumDataMapper(songListDataMapper)

    private fun makeNetworkAlbum(
        id: String? = null,
        title: String? = null
    ): NetworkAlbum {
        return NetworkAlbum(id, title, networkSongList)
    }

    @Test
    fun `map should replace null values with defaults`() {
        val dto = makeNetworkAlbum()

        val actual = sut.map(dto)

        assertThat(actual.id).isEmpty()
        assertThat(actual.title).isEmpty()
    }

    @Test
    fun `map should assign correct values`() {
        val dto = makeNetworkAlbum("id", "title")

        val actual = sut.map(dto)

        assertThat(actual.id).isEqualTo("id")
        assertThat(actual.title).isEqualTo("title")
        assertThat(actual.songs).isEqualTo(songList)
    }
}