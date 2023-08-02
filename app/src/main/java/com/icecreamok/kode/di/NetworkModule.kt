package com.icecreamok.kode.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    private val timeOut: Long = 30

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(
                timeOut,
                TimeUnit.SECONDS
            )
        okBuilder.addInterceptor(HttpLoggingInterceptor())
        return okBuilder.build()
    }


    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
}

