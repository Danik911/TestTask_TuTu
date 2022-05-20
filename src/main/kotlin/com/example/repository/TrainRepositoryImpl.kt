package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Train

const val PREV_PAGE_KEY = "prevPage"
const val NEXT_PAGE_KEY = "nextPage"

class TrainRepositoryImpl : TrainRepository {

    override val trains: Map<Int, List<Train>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
        )
    }


    override val page1: List<Train> = listOf(
        Train(
            id = 1,
            model = "",
            image = "",
            about = ""
        ),
        Train(
            id = 2,
            model = "",
            image = "",
            about = ""
        ),
        Train(
            id = 3,
            model = "",
            image = "",
            about = ""
        ),
    )
    override val page2: List<Train> = listOf(
        Train(
            id = 4,
            model = "",
            image = "",
            about = ""
        ),
        Train(
            id = 5,
            model = "",
            image = "",
            about = ""
        ),
        Train(
            id = 6,
            model = "",
            image = "",
            about = ""
        ),
    )
    override val page3: List<Train> = listOf(
        Train(
            id = 7,
            model = "",
            image = "",
            about = ""
        ),
        Train(
            id = 8,
            model = "",
            image = "",
            about = ""
        ),
        Train(
            id = 9,
            model = "",
            image = "",
            about = ""
        ),
    )


    override suspend fun getAllTrains(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "OK",
            prevPage = calculatePage(page)[PREV_PAGE_KEY],
            nextPage = calculatePage(page)[NEXT_PAGE_KEY],
            trains = trains[page]!!,
            lastUpdate = System.currentTimeMillis()
        )
    }

    override suspend fun searchTrains(model: String?): ApiResponse {
        return ApiResponse(
                success = true,
        message = "OK",
        trains = findTrains(model)
        )
    }


    private fun calculatePage(page: Int) =
        mapOf<String, Int?>(
            PREV_PAGE_KEY to if (page in 2..3) page.minus(1) else null,
            NEXT_PAGE_KEY to if (page in 1..2) page.plus(1) else null
        )
    private fun findTrains(query: String?): List<Train> {

        val searchResult = mutableListOf<Train>()

        return if (!query.isNullOrEmpty()) {
            trains.forEach { (_, trains) ->
                trains.forEach { train ->
                    if (train.model.lowercase().contains(query.lowercase())) {
                        searchResult.add(train)
                    }
                }
            }
            searchResult
        } else {
            return emptyList()
        }
    }
}