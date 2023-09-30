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


//fun Route.configureWantedPersonRouting() {
//    route("/wanted-person") {
//        get {
//            val id = call.receive<WantedPersonRequest>().id
//            val wantedPerson = getWantedPersonById(id)
//            wantedPerson?.let {
//                call.respond(HttpStatusCode.OK, it)
//            } ?: run {
//                call.respond(HttpStatusCode.NotFound)
//            }
//        }
//    }
//
//    route("create-update-wantedPerson") {
//        post {
//            val request = try {
//                call.receive<WantedPerson>()
//            } catch (e: Exception) {
//                call.respond(HttpStatusCode.BadRequest)
//                return@post
//            }
//            if (createWantedPersonOrUpdateById(request)) {
//                call.respond(HttpStatusCode.OK)
//            } else {
//                call.respond(HttpStatusCode.InternalServerError)
//            }
//        }
//    }
//
//    route("delete-wantedPerson") {
//        post {
//            val request = try {
//                call.receive<WantedPersonRequest>()
//            } catch (e: Exception) {
//                call.respond(HttpStatusCode.BadRequest)
//                return@post
//            }
//            if (deleteWantedPersonById(request.id)) {
//                call.respond(HttpStatusCode.OK)
//            } else {
//                call.respond(HttpStatusCode.InternalServerError)
//            }
//        }
//    }
//}



