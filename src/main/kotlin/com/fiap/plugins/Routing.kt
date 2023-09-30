package com.fiap.plugins

import com.fiap.data.datasource.WantedPersonDataSource
import com.fiap.routes.getWantedPerson
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val wantedPersonDataSource: WantedPersonDataSource by inject()

    routing {
        getWantedPerson(wantedPersonDataSource)
    }
}
