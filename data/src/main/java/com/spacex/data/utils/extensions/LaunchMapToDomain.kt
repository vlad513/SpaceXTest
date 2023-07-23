package com.spacex.data.utils.extensions

import com.spacex.data.networking.models.launches.DocksModelData
import com.spacex.data.networking.models.launches.docks.CoreModelData
import com.spacex.data.networking.models.launches.docks.FailuresModelData
import com.spacex.domain.models.launch.DocksModelDomain
import com.spacex.domain.models.launch.docks.CoreModelDomain
import com.spacex.domain.models.launch.docks.FailuresModelDomain
import com.spacex.domain.models.launch.docks.FairingsModelDomain
import com.spacex.domain.models.launch.docks.LinksModelDomain
import com.spacex.domain.models.launch.docks.links.FlickrModelDomain
import com.spacex.domain.models.launch.docks.links.PatchModelDomain
import com.spacex.domain.models.launch.docks.links.RedditModelDomain
import com.spacex.domain.repository.Repository

fun Repository.mapLaunch(docs: List<DocksModelData>): List<DocksModelDomain> {
    val dock = arrayListOf<DocksModelDomain>()
    docs.forEach {
        dock.add(
            DocksModelDomain(
                fairings = it.fairings?.let { it1 ->
                    FairingsModelDomain(
                        reused = it.fairings.reused,
                        recovery_attempt = it.fairings.recovery_attempt,
                        recovered = it.fairings.recovered,
                        ships = it1.ships
                    )
                },
                links = LinksModelDomain(
                    patch = PatchModelDomain(
                        small = it.links?.patch?.small, large = it.links?.patch?.large
                    ),
                    reddit = RedditModelDomain(
                        campaign = it.links?.reddit?.campaign,
                        launch = it.links?.reddit?.launch,
                        media = it.links?.reddit?.media,
                        recovery = it.links?.reddit?.recovery
                    ),
                    flickr = FlickrModelDomain(
                        small = it.links?.flickr?.small!!, original = it.links.flickr.original
                    ),
                    presskit = it.links.presskit,
                    webcast = it.links.webcast,
                    youtube_id = it.links.youtube_id,
                    article = it.links.article,
                    wikipedia = it.links.wikipedia
                ),
                static_fire_date_unix = it.static_fire_date_unix,
                net = it.net,
                window = it.window,
                rocket = it.rocket,
                success = it.success,
                failures = failures(it = it.failures as List<FailuresModelData>),
                details = it.details,
                static_fire_date_utc = it.static_fire_date_utc,
                crew = it.crew,
                ships = it.ships,
                capsules = it.capsules,
                payloads = it.payloads,
                launchpad = it.launchpad,
                flight_number = it.flight_number,
                name = it.name,
                date_utc = it.date_utc,
                date_unix = it.date_unix,
                date_local = it.date_local,
                date_precision = it.date_precision,
                upcoming = it.upcoming,
                cores = cores(it.cores as List<CoreModelData>),
                auto_update = it.auto_update,
                tbd = it.tbd,
                launch_library_id = it.launch_library_id,
                id = it.id
            )
        )
    }
    return dock
}

private fun cores(it: List<CoreModelData>): List<CoreModelDomain> {
    val core = arrayListOf<CoreModelDomain>()
    it.forEach {
        core.add(
            CoreModelDomain(
                core = it.core,
                flight = it.flight,
                gridfins = it.gridfins,
                legs = it.legs,
                reused = it.reused,
                landing_attempt = it.landing_attempt,
                landing_success = it.landing_success,
                landing_type = it.landing_type,
                landpad = it.landpad
            )
        )
    }
    return core
}

private fun failures(it: List<FailuresModelData>): List<FailuresModelDomain> {
    val failures = arrayListOf<FailuresModelDomain>()
    it.forEach {
        failures.add(
            FailuresModelDomain(
                time = it.time, altitude = it.altitude, reason = it.reason
            )
        )
    }
    return failures
}