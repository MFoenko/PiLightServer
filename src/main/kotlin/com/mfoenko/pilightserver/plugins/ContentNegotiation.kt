package com.mfoenko.pilightserver.plugins

import com.ryanharter.ktor.moshi.moshi
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.configureContentNegotiation() {

    install(ContentNegotiation){
        moshi {

        }
    }
}
