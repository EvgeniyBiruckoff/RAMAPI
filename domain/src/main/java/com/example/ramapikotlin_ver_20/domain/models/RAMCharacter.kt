package com.example.ramapikotlin_ver_20.domain.models



data class RAMCharacter(
    val episode: List<String>,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val species: String,
    val status: String,

)