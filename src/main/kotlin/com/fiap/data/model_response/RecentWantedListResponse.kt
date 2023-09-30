package com.fiap.data.model_response

import com.fiap.data.model.WantedPerson
import kotlinx.serialization.Serializable

@Serializable
data class RecentWantedListResponse(
    val items: List<WantedPerson>,
    val page: Int
)
