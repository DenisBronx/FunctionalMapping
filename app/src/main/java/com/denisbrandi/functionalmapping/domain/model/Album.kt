package com.denisbrandi.functionalmapping.domain.model

// Aggregate
data class Album(
    val id: String,
    val title: String,
    val songs: List<Song>
)