package com.spacex.data.networking.models.launches

import com.spacex.data.networking.models.launches.docks.CoreModelData
import com.spacex.data.networking.models.launches.docks.FailuresModelData
import com.spacex.data.networking.models.launches.docks.FairingsModelData
import com.spacex.data.networking.models.launches.docks.LinksModelData

data class DocksModelData(
    val fairings: FairingsModelData?,
    val links: LinksModelData?,
    val static_fire_date_utc: String?,
    val static_fire_date_unix: Int?,
    val net: Boolean?,
    val window: Int?,
    val rocket: String?,
    val success: Boolean?,
    val failures: List<FailuresModelData?>,
    val details: String?,
    val crew: List<String?>,
    val ships: List<String?>,
    val capsules: List<String?>,
    val payloads: List<String?>,
    val launchpad: String?,
    val flight_number: Int?,
    val name: String?,
    val date_utc: String?,
    val date_unix: Int?,
    val date_local: String?,
    val date_precision: String?,
    val upcoming: Boolean?,
    val cores: List<CoreModelData?>,
    val auto_update: Boolean?,
    val tbd: Boolean?,
    val launch_library_id: String?,
    val id: String?
)
