package com.example.routs

import com.example.repository.TrainRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Routing.searchTrains() {

    val trainRepository: TrainRepository by inject()
    get("/tutu/trains/search") {

        val query = call.request.queryParameters["name"]
        val apiResponse = trainRepository.searchTrains(model = query)

        call.respond(message = apiResponse, status = HttpStatusCode.OK)
    }
}
