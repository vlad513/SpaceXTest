package com.spacex.domain.models.launch.docks

data class CoreModelDomain (
        val core: String?,
        val flight: Int?,
        val gridfins: Boolean?,
        val legs: Boolean?,
        val reused: Boolean?,
        val landing_attempt: Boolean?,
        val landing_success: Boolean?,
        val landing_type: String?,
        val landpad: String?
        ):java.io.Serializable