package com.spacex.data.networking.models.crew

data class CrewModelData(
    val name: String?,
    val agency: String?,
    val image: String?,
    val wikipedia: String?,
    val launches: List<String?>,
    val status: String?,
    val id: String?
)