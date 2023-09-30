package com.fiap.data.model_request

import com.fiap.data.model.RecentWantedList
import com.fiap.data.model.WantedPerson

data class RecentWantedListRequest(
    val items: List<WantedPerson>,
    val page: Int
)

fun RecentWantedListRequest.toRecentWantedList() = RecentWantedList(
    items = this.items,
    page = this.page
)

