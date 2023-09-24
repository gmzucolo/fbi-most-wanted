package com.fiap.models

data class RecentWantedListRequest(
    val items: List<WantedPerson>,
    val page: Int
)

fun RecentWantedListRequest.toRecentWantedList() = RecentWantedList(
    items = this.items,
    page = this.page
)

