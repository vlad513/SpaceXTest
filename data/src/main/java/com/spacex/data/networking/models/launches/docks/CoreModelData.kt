package com.spacex.data.networking.models.launches.docks

data class CoreModelData (
    val core: String?,
    val flight: Int?,
    val gridfins: Boolean?,
    val legs: Boolean?,
    val reused: Boolean?,
    val landing_attempt: Boolean?,
    val landing_success: Boolean?,
    val landing_type: String?,
    val landpad: String?
        )

