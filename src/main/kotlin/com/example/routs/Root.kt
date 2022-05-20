package com.example.routs

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.root() {
    get("/") {
        call.respond(
            status = HttpStatusCode.OK,
            message = "Welcome to TuTu server!"
        )
    }
}