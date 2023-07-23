package com.spacex.data.networking.models.launches.docks

data class FairingsModelData(
    val reused: Boolean?,
    val recovery_attempt: Boolean?,
    val recovered: Boolean?,
    val ships: List<String?>
)




