package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Train

interface TrainRepository {


    val trains: Map<Int, List<Train>>

    val page1: List<Train>
    val page2: List<Train>
    val page3: List<Train>

    suspend fun getAllTrains(page: Int = 1): ApiResponse
    suspend fun searchTrains(model: String?): ApiResponse
}