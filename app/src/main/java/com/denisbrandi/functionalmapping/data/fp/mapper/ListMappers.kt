package com.denisbrandi.functionalmapping.data.fp.mapper

fun <I, O> mapList(input: List<I>, mapListItem: (I) -> O): List<O> {
    return input.map { mapListItem(it) }
}

fun <I, O> mapNullInputList(input: List<I>?, mapListItem: (I) -> O): List<O> {
    return input?.map { mapListItem(it) } ?: emptyList()
}

fun <I, O> mapNullOutputList(input: List<I>, mapListItem: (I) -> O): List<O>? {
    return if (input.isEmpty()) null else input.map { mapListItem(it) }
}