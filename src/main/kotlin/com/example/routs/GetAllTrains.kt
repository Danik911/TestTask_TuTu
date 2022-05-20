package com.example.routs

import com.example.models.ApiResponse
import com.example.repository.TrainRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Routing.getAllTrains() {

    val trainRepository: TrainRepository by inject()

    get("/tutu/trains") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..3)

            val apiResponse = trainRepository.getAllTrains(page = page)

            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: java.lang.NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Invalid request, only numbers are accepted"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: java.lang.IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only numbers from 1 to 5 are accepted"),
                status = HttpStatusCode.NotFound
            )
        }
    }
}