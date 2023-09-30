package com.fiap.plugins

import com.fiap.api.WantedPersonAPI
import com.fiap.data.datasource.WantedPersonDataSource
import com.fiap.data.datasource.WantedPersonListDataSource
import com.fiap.routes.getWantedPerson
import com.fiap.routes.getWantedPersonList
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val wantedPersonDataSource: WantedPersonDataSource by inject()
    val wantedPersonListDataSource: WantedPersonListDataSource by inject()
    val wantedPersonAPI: WantedPersonAPI by inject()

    routing {
        getWantedPerson(wantedPersonDataSource)
        getWantedPersonList(wantedPersonListDataSource, wantedPersonAPI)
    }
}
