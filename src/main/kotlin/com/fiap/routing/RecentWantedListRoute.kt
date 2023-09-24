package com.fiap.routing

import com.fiap.models.RecentWantedListDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRecentWantedListRouting(
    recentWantedListDataSource: RecentWantedListDataSource
) {
    routing {
        get("/wanted") {
            call.respond(
                HttpStatusCode.OK, recentWantedListDataSource.getRecentWantedList()
            )
        }
    }

    routing {
        get("/wanted/{page}") {
            val page = call.parameters["page"]?.toInt() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }
            call.respond(
                HttpStatusCode.OK, recentWantedListDataSource.getRecentWantedListByPage(page)
            )
        }
    }
}