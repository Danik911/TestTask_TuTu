package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Train(
    val id: Int,
    val model: String,
    val image: String,
    val about: String,
)
