package com.fiap.plugins

import com.fiap.models.WantedPersonDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureWantedPersonRouting(
    wantedPersonDataSource: WantedPersonDataSource
) {
    routing {
        get("/wanted-person/{id}") {
            val id = call.parameters["id"] ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            call.respond(HttpStatusCode.OK, wantedPersonDataSource.getWantedPersonById(id))
        }
    }
}