package com.fiap.data.model_response

import kotlinx.serialization.Serializable

@Serializable
data class WantedPersonResponse(
    val ageMax: Int,
    val ageMin: Int,
    val caution: String,
    val status: String,
    val description: String,
    val details: String,
    val hair: String,
    val heightMax: Int,
    val heightMin: Int,
    val locations: List<String>,
    val nationality: String,
    val personClassification: String,
    val placeOfBirth: String,
    val possibleCountries: List<String>,
    val race: String,
    val sex: String,
    val title: String,
    val uid: String,
    val id: String
)
