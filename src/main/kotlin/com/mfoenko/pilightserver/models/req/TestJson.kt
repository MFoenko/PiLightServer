package com.mfoenko.pilightserver.models.req

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TestJson(
    val myValue: Int?,
)