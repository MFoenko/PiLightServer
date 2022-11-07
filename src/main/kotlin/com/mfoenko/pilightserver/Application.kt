package com.mfoenko.pilightserver

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.mfoenko.pilightserver.plugins.configureContentNegotiation
import com.mfoenko.pilightserver.plugins.configureRouting
import com.mfoenko.pilightserver.plugins.configureSockets

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val moshi = configureContentNegotiation()
    configureSockets(moshi)
    configureRouting()
}
