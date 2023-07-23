package com.spacex.domain.models.launch.docks

data class FailuresModelDomain (
        val time: Int?,
        val altitude: Int?,
        val reason: String?
        ):java.io.Serializable