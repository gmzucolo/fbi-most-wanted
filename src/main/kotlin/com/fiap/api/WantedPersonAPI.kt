package com.fiap.api

import com.fiap.data.model.WantedPerson
import com.fiap.data.model_response.RecentWantedListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

interface WantedPersonAPI {
    suspend fun getRecentWantedList(): RecentWantedListResponse
    suspend fun getWantedPersonById(id: String): WantedPerson
}

class WantedPersonImpl(private val client: HttpClient) : WantedPersonAPI {
    override suspend fun getRecentWantedList(): RecentWantedListResponse {
        return client.get("https://api.fbi.gov/@wanted?pageSize=5&page=1&sort_on=modified&sort_order=desc") {
            contentType(ContentType.Application.Json)
        }.body()
    }

    override suspend fun getWantedPersonById(id: String): WantedPerson {
        TODO("Not yet implemented")
    }
}