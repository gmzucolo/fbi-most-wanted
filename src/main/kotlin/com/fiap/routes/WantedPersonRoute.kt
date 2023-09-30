package com.fiap.routes

import com.fiap.data.datasource.WantedPersonDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getWantedPerson(wantedPersonDataSource: WantedPersonDataSource) {
    get("/wanted-person/{id}") {
        val id = call.parameters["id"] ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        wantedPersonDataSource.getWantedPersonById(id)?.let { it1 ->
            call.respond(
                HttpStatusCode.OK, it1
            )
        }
    }
}
