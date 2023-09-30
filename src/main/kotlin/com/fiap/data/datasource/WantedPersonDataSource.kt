package com.fiap.data.datasource

import com.fiap.data.model.WantedPerson

interface WantedPersonDataSource {
    suspend fun getWantedPersonById(id: String): WantedPerson?
}