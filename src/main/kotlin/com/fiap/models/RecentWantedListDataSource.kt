package com.fiap.models

interface RecentWantedListDataSource {
    suspend fun getRecentWantedList(): List<RecentWantedListResponse>
    suspend fun getRecentWantedListByPage(page: Int): RecentWantedListResponse

}