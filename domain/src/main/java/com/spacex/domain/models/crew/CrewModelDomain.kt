package com.spacex.domain.models.crew

data class CrewModelDomain(
    val name: String?,
    val agency: String?,
    val image: String?,
    val wikipedia: String?,
    val launches: List<String?>,
    val status: String?,
    val id: String?
) : java.io.Serializable
