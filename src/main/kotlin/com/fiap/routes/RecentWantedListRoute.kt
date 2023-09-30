package com.fiap.routes

import com.fiap.data.datasource.RecentWantedListDataSource
import com.fiap.data.model.toWantedPersonResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getWantedPersonList(wantedPersonListDataSource: RecentWantedListDataSource) {
    get("/wanted") {
        val response = wantedPersonListDataSource.getRecentWantedList().map {
            it.toWantedPersonResponse()
        }
        call.respond(
            HttpStatusCode.OK, response
        )
    }

    get("/wanted/{page}") {
        val page = call.parameters["page"]?.toInt() ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val response = wantedPersonListDataSource.getRecentWantedListByPage(page).map {
            it.toWantedPersonResponse()
        }
        call.respond(
            HttpStatusCode.OK, response
        )
    }
}












//fun Application.configureRecentWantedListRouting(service: WantedPersonService) {
//    routing {
//        get("/wanted") {
//            val response = service.getRecentWantedList().map {
//                it.toWantedPersonResponse()
//            }
//            call.respond(
//                HttpStatusCode.OK, response
//            )
//        }
//    }
//
//    routing {
//        get("/wanted/{page}") {
//            val page = call.parameters["page"] ?: kotlin.run {
//                call.respond(HttpStatusCode.BadRequest)
//                return@get
//            }
//            val response = service.getRecentWantedList(page).map {
//                it.toWantedPersonResponse()
//            }
//            call.respond(
//                HttpStatusCode.OK, response
//            )
//        }
//    }
//
//    routing {
//        get("/wanted-person/{id}") {
//            val id = call.parameters["id"] ?: kotlin.run {
//                call.respond(HttpStatusCode.BadRequest)
//                return@get
//            }
//            service.getWantedPersonById(id)?.let { it1 ->
//                call.respond(
//                    HttpStatusCode.OK, it1.toWantedPersonResponse()
//                )
//            }
//        }
//    }
//}