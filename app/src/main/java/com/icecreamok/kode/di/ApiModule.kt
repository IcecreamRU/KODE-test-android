package com.icecreamok.kode.di

import com.icecreamok.kode.data.api.ApiService
import com.icecreamok.kode.data.api.EndpointResolver
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class ApiModule {
    @Provides
    fun bindApiService(
        @Named("defaultRetrofit") retrofit: Retrofit.Builder,
        endpointResolver: EndpointResolver
    ): ApiService {
        return retrofit.baseUrl(endpointResolver.getEndpointUrl()).build()
            .create(ApiService::class.java)
    }
}