package com.spacex.data.networking.retrofit

import com.spacex.data.networking.remote.ApiService


class RetrofitCreateRequest (val retrofitBuilder: RetrofitBuilder) {

    val create = retrofitBuilder.retrofit.create(ApiService::class.java)
}