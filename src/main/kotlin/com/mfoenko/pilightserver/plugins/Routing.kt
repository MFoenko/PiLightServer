package com.mfoenko.pilightserver.plugins

import com.mfoenko.pilightserver.models.req.PolymorphicJson
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respond(HttpStatusCode.OK)
        }
    }
}
