package com.icecreamok.kode.data.repository

import com.icecreamok.kode.data.model.users.UsersResponse
import retrofit2.Response

enum class RESPONSE {
    SUCCESS,
    GENERIC,
    HTTP_500
}

interface UsersRepository {
    suspend fun getUsers(expectedResponse: RESPONSE): Response<UsersResponse>
}