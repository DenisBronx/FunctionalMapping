package com.denisbrandi.functionalmapping.data.oop.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}