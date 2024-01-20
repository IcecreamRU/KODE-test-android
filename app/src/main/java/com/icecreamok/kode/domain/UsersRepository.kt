package com.icecreamok.kode.domain

import com.icecreamok.kode.data.model.users.UserDto

enum class ExpectedResponse {
    SUCCESS,
    GENERIC,
    HTTP_500
}

interface UsersRepository {
    suspend fun getUsers(expectedResponse: ExpectedResponse): Result<List<UserDto>>
    suspend fun getCategories(expectedResponse: ExpectedResponse): Result<List<String>>
}