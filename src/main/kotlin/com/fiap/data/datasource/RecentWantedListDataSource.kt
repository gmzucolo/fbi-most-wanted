package com.fiap.data.datasource

import com.fiap.data.model.WantedPerson
import com.fiap.data.model_response.RecentWantedListResponse

interface RecentWantedListDataSource {
    suspend fun getRecentWantedList(): List<WantedPerson>
    suspend fun getRecentWantedListByPage(page: Int): List<WantedPerson>

}