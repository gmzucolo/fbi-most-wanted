package com.fiap.models

data class RecentWantedList(
    val items: List<WantedPerson>,
    val page: Int
)

fun RecentWantedList.toRecentWantedListResponse() = RecentWantedListResponse(
    items = this.items,
    page = this.page
)