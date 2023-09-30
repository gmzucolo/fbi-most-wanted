package com.fiap.data.datasource

import com.fiap.data.model.WantedPerson
import com.fiap.data.model_response.RecentWantedListResponse

interface WantedPersonListDataSource {
    suspend fun getRecentWantedList(): List<WantedPerson>
    suspend fun getRecentWantedListByPage(page: Int, pageSize: Int): List<WantedPerson>
    suspend fun insertWantedPersonList(wantedPersonList: RecentWantedListResponse): Boolean
}