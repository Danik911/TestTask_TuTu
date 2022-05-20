package com.example.plugins

import com.example.routs.getAllTrains
import com.example.routs.root
import com.example.routs.searchTrains
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        root()
        searchTrains()
        getAllTrains()
    }
}
