package com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

class ListMapperImplTest {

    private val input1: Any = mock()
    private val input2: Any = mock()
    private val output1: Any = mock()
    private val output2: Any = mock()

    private val mapper: Mapper<Any, Any> = mock {
        whenever(it.map(input1)).thenReturn(output1)
        whenever(it.map(input2)).thenReturn(output2)
    }
    private val sut = ListMapperImpl(mapper)

    @Test
    fun `map should return empty list when input list is empty`() {
        val actual = sut.map(emptyList())

        assertThat(actual).isEmpty()
    }

    @Test
    fun `map should return mapped list when input list is 1`() {
        val actual = sut.map(listOf(input1))

        assertThat(actual.size).isEqualTo(1)
        assertThat(actual[0]).isEqualTo(output1)
    }

    @Test
    fun `map should return mapped list when input list is many`() {
        val actual = sut.map(listOf(input1, input2))

        assertThat(actual.size).isEqualTo(2)
        assertThat(actual[0]).isEqualTo(output1)
        assertThat(actual[1]).isEqualTo(output2)
    }
}