package com.fiap.data.model_request

import kotlinx.serialization.Serializable

@Serializable
data class WantedPersonRequest(
    val id: String
)

//fun WantedPersonRequest.toWantedPerson(id: String): WantedPerson {
//    return WantedPerson(
//        ageMax = ageMax,
//        ageMin = ageMin,
//        caution = caution,
//        status = status,
//        description = description,
//        details = details,
//        hair = hair,
//        heightMax = heightMax,
//        heightMin = heightMin,
//        locations = locations,
//        nationality = nationality,
//        personClassification = personClassification,
//        placeOfBirth = placeOfBirth,
//        possibleCountries = possibleCountries,
//        race = race,
//        sex = sex,
//        title = title,
//        uid = uid,
//        id = id
//    )
//}
