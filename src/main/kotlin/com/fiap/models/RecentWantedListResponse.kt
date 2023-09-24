package com.fiap.models

import kotlinx.serialization.Serializable

@Serializable
data class RecentWantedListResponse(
    val items: List<WantedPerson>,
    val page: Int
)
