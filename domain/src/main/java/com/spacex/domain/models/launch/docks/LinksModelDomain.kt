package com.spacex.domain.models.launch.docks

import com.spacex.domain.models.launch.docks.links.FlickrModelDomain
import com.spacex.domain.models.launch.docks.links.PatchModelDomain
import com.spacex.domain.models.launch.docks.links.RedditModelDomain

data class LinksModelDomain(
    val patch: PatchModelDomain?,
    val reddit: RedditModelDomain?,
    val flickr: FlickrModelDomain?,
    val presskit: String?,
    val webcast: String?,
    val youtube_id: String?,
    val article: String?,
    val wikipedia: String?
):java.io.Serializable
