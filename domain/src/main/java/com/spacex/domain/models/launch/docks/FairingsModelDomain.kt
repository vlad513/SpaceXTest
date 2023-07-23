package com.spacex.domain.models.launch.docks

data class FairingsModelDomain(
    val reused: Boolean?,
    val recovery_attempt: Boolean?,
    val recovered: Boolean?,
    val ships: List<String?>
):java.io.Serializable
