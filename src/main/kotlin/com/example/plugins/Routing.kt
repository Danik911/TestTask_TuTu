package com.example.plugins

import com.example.routs.getAllTrains
import com.example.routs.root
import com.example.routs.searchTrains
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        root()
        searchTrains()
        getAllTrains()
    }
}
