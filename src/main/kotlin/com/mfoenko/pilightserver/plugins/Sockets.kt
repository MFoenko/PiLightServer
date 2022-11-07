package com.mfoenko.pilightserver.plugins

import com.mfoenko.pilightserver.models.req.ChangeNotification
import com.mfoenko.pilightserver.models.req.PolymorphicJson
import com.squareup.moshi.Moshi
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.time.Duration
import io.ktor.server.application.*

fun Application.configureSockets(moshi: Moshi) {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    routing {
        webSocket("/ws") { // websocketSession
            for (frame in incoming) {
                if (frame is Frame.Text) {
                    val text = frame.readText()
                    val polyJson = moshi.adapter(PolymorphicJson::class.java).fromJson(text)
                    if(polyJson == null){
                        outgoing.send(Frame.Text("Unrecognized format"))
                        return@webSocket
                    }
                    if(polyJson.type == null){
                        outgoing.send(Frame.Text("Unrecognized type"))
                        return@webSocket
                    }

                    when(polyJson.type){
                        PolymorphicJson.Type.Close -> {
                            close(CloseReason(CloseReason.Codes.NORMAL, "Client requested Close"))
                        }
                        PolymorphicJson.Type.Update -> {
                            val change = moshi.adapter(ChangeNotification::class.java).fromJson(text)
                            outgoing.send(Frame.Text("changed to ${change?.update}"))
                        }
                    }

                }
            }
        }
    }
}
