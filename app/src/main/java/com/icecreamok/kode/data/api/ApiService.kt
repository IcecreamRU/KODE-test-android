package com.icecreamok.kode.data.api

import com.icecreamok.kode.data.model.users.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("/users")
    suspend fun getUsers(@Header("Prefer") preferHeader: String): Response<UsersResponse>
}