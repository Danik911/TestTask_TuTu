package com.example.routs

import com.example.repository.TrainRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Routing.searchTrains() {

    val trainRepository: TrainRepository by inject()
    get("/tutu/trains/search") {

        val query = call.request.queryParameters["model"]
        val apiResponse = trainRepository.searchTrains(model = query)

        call.respond(message = apiResponse, status = HttpStatusCode.OK)
    }
}
