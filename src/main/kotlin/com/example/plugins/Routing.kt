package com.example.plugins

import com.example.routs.getAllTrains
import com.example.routs.root
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {

        root()
        getAllTrains(app = application)
        static("/images") {
            resources("images")
        }
    }

}
