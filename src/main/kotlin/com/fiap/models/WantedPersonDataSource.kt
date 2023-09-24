package com.fiap.models

interface WantedPersonDataSource {
    suspend fun getWantedPersonById(id: String): WantedPerson

}