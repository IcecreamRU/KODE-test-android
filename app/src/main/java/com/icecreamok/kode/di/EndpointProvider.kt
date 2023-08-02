package com.icecreamok.kode.di

import com.icecreamok.kode.BuildConfig
import com.icecreamok.kode.data.api.EndpointResolver
import javax.inject.Inject

class EndpointProvider
@Inject constructor() : EndpointResolver {

    override fun getEndpointUrl(): String = BuildConfig.SERVER_URL

}