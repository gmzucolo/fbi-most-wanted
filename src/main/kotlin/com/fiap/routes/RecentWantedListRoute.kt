package com.fiap.routes

import com.fiap.api.WantedPersonAPI
import com.fiap.data.datasource.WantedPersonListDataSource
import com.fiap.data.model.toWantedPersonResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getWantedPersonList(
    wantedPersonListDataSource: WantedPersonListDataSource,
    wantedPersonAPI: WantedPersonAPI
) {
    get("/wanted") {
        val responseAPI = wantedPersonAPI.getRecentWantedList()
        call.respond(
            HttpStatusCode.OK, responseAPI
        )
        val success = wantedPersonListDataSource.insertWantedPersonList(responseAPI)
        if (!success) {
            call.respond(HttpStatusCode.InternalServerError)
            return@get
        }
        val response = wantedPersonListDataSource.getRecentWantedList().map {
            it.toWantedPersonResponse()
        }
    }

    get("/wanted/{pageSize}&{page}") {
        val page = call.parameters["page"] ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val pageSize = call.parameters["pageSize"] ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val response = wantedPersonListDataSource.getRecentWantedListByPage(page.toInt(), pageSize.toInt()).map {
            it.toWantedPersonResponse()
        }
        call.respond(
            HttpStatusCode.OK, response
        )
    }
}
