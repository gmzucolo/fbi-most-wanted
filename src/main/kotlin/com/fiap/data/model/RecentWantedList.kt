package com.fiap.data.model

import com.fiap.data.model_response.RecentWantedListResponse

data class RecentWantedList(
    val items: List<WantedPerson>,
    val page: Int
)

fun RecentWantedList.toRecentWantedListResponse() = RecentWantedListResponse(
    items = this.items,
    page = this.page
)