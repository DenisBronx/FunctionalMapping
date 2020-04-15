package com.denisbrandi.mediumarticles.functionalmapping.data.oop.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}