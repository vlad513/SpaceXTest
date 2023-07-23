package com.spacex.domain.models.launch

import com.spacex.domain.models.launch.docks.CoreModelDomain
import com.spacex.domain.models.launch.docks.FailuresModelDomain
import com.spacex.domain.models.launch.docks.FairingsModelDomain
import com.spacex.domain.models.launch.docks.LinksModelDomain

data class DocksModelDomain(
    val fairings: FairingsModelDomain?,
    val links: LinksModelDomain?,
    val static_fire_date_utc: String?,
    val static_fire_date_unix: Int?,
    val net: Boolean?,
    val window: Int?,
    val rocket: String?,
    val success: Boolean?,
    val failures: List<FailuresModelDomain?>,
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
    val cores: List<CoreModelDomain?>,
    val auto_update: Boolean?,
    val tbd: Boolean?,
    val launch_library_id: String?,
    val id: String?
):java.io.Serializable
