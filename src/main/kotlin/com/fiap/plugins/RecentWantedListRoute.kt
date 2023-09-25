package com.fiap.plugins

import com.fiap.service.WantedPersonService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRecentWantedListRouting(service: WantedPersonService) {
    routing {
        get("/@wanted") {
            val response = service.getRecentWantedList().map {
                it.toRecentWantedListResponse()
            }
            call.respond(
                HttpStatusCode.OK, response
            )
        }
    }

    routing {
        get("/@wanted/{page}") {
            val page = call.parameters["page"] ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            val response = service.getRecentWantedList(page).map {
                it.toRecentWantedListResponse()
            }
            call.respond(
                HttpStatusCode.OK, response
            )
        }
    }

    routing {
        get("/@wanted-person/{id}") {
            val id = call.parameters["id"] ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            service.getWantedPersonById(id)?.let { it1 ->
                call.respond(
                    HttpStatusCode.OK, it1.toRecentWantedListResponse(
                    )
                )
            }
        }
    }
}