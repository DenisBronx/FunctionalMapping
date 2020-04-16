package com.denisbrandi.functionalmapping.data.fp.mapper

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class ListMappersKtTest {

    private val input1: Any = mock()
    private val input2: Any = mock()
    private val output1: Any = mock()
    private val output2: Any = mock()

    private val inputOutputMap = mapOf(input1 to output1, input2 to output2)
    private val mapListItem: (Any) -> Any = { input -> inputOutputMap.getValue(input) }

    //region mapList
    @Test
    fun `mapList should return empty list when input list is empty`() {
        val actual = mapList(emptyList(), mapListItem)

        assertThat(actual).isEmpty()
    }

    @Test
    fun `mapList should return mapped list when input list is 1`() {
        val actual = mapList(listOf(input1), mapListItem)

        assertThat(actual.size).isEqualTo(1)
        assertThat(actual[0]).isEqualTo(output1)
    }

    @Test
    fun `mapList should return mapped list when input list is many`() {
        val actual = mapList(listOf(input1, input2), mapListItem)

        assertThat(actual.size).isEqualTo(2)
        assertThat(actual[0]).isEqualTo(output1)
        assertThat(actual[1]).isEqualTo(output2)
    }
    //endregion

    //region mapNullInputList
    @Test
    fun `mapNullInputList should return empty list when input list is null`() {
        val actual = mapNullInputList(null, mapListItem)

        assertThat(actual).isEmpty()
    }

    @Test
    fun `mapNullInputList should return empty list when input list is empty`() {
        val actual = mapNullInputList(emptyList(), mapListItem)

        assertThat(actual).isEmpty()
    }

    @Test
    fun `mapNullInputList should return mapped list when input list is 1`() {
        val actual = mapNullInputList(listOf(input1), mapListItem)

        assertThat(actual.size).isEqualTo(1)
        assertThat(actual[0]).isEqualTo(output1)
    }

    @Test
    fun `mapNullInputList should return mapped list when input list is many`() {
        val actual = mapNullInputList(listOf(input1, input2), mapListItem)

        assertThat(actual.size).isEqualTo(2)
        assertThat(actual[0]).isEqualTo(output1)
        assertThat(actual[1]).isEqualTo(output2)
    }
    //endregion

    //region mapNullOutputList
    @Test
    fun `mapNullOutputList should return empty list when input list is empty`() {
        val actual = mapNullOutputList(emptyList(), mapListItem)

        assertThat(actual).isNull()
    }

    @Test
    fun `mapNullOutputList should return mapped list when input list is 1`() {
        val actual = mapNullOutputList(listOf(input1), mapListItem)

        assertThat(actual!!.size).isEqualTo(1)
        assertThat(actual[0]).isEqualTo(output1)
    }

    @Test
    fun `mapNullOutputList should return mapped list when input list is many`() {
        val actual = mapNullOutputList(listOf(input1, input2), mapListItem)

        assertThat(actual!!.size).isEqualTo(2)
        assertThat(actual[0]).isEqualTo(output1)
        assertThat(actual[1]).isEqualTo(output2)
    }
    //endregion

}