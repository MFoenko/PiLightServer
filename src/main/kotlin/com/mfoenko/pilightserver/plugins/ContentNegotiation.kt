package com.mfoenko.pilightserver.plugins

import com.ryanharter.ktor.moshi.moshi
import com.squareup.moshi.Moshi
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.configureContentNegotiation(): Moshi {

    val moshi = Moshi.Builder().build()

    install(ContentNegotiation){
        moshi(moshi)
    }

    return moshi
}
