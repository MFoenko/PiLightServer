package com.mfoenko.pilightserver.models.req

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PolymorphicJson(
    @Json(name = "type") val type: Type?,
) {
    enum class Type {
        @Json(name = "close") Close,
        @Json(name = "update") Update,
    }
}

fun PolymorphicJson.Type.jsonClass() = when(this){
    PolymorphicJson.Type.Close -> TODO()
    PolymorphicJson.Type.Update -> ChangeNotification::class
}

