package com.spacex.data.networking.models.launches.docks

import com.spacex.data.networking.models.launches.docks.links.FlickrModelData
import com.spacex.data.networking.models.launches.docks.links.PatchModelData
import com.spacex.data.networking.models.launches.docks.links.RedditModelData

data class LinksModelData(
    val patch: PatchModelData?,
    val reddit: RedditModelData?,
    val flickr: FlickrModelData?,
    val presskit: String?,
    val webcast: String?,
    val youtube_id: String?,
    val article: String?,
    val wikipedia: String?
)



