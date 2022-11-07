package com.mfoenko.pilightserver.plugins

import com.mfoenko.pilightserver.models.req.TestJson
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respond(HttpStatusCode.OK, TestJson(1))
        }
    }
}
