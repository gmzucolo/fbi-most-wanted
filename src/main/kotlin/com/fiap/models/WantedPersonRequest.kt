package com.fiap.models

import kotlinx.serialization.Serializable

@Serializable
data class WantedPersonRequest(
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
    val uid: String
)

fun WantedPersonRequest.toWantedPerson(id: String): WantedPerson {
    return WantedPerson(
        ageMax = ageMax,
        ageMin = ageMin,
        caution = caution,
        status = status,
        description = description,
        details = details,
        hair = hair,
        heightMax = heightMax,
        heightMin = heightMin,
        locations = locations,
        nationality = nationality,
        personClassification = personClassification,
        placeOfBirth = placeOfBirth,
        possibleCountries = possibleCountries,
        race = race,
        sex = sex,
        title = title,
        uid = uid,
        id = id
    )
}
