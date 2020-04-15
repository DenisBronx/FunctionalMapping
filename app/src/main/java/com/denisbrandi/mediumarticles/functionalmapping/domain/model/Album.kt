package com.denisbrandi.mediumarticles.functionalmapping.domain.model

// Aggregate
data class Album(
    val id: String,
    val title: String,
    val songs: List<Song>
)