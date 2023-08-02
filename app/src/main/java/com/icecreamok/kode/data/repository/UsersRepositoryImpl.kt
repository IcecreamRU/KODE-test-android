package com.icecreamok.kode.data.repository

import com.icecreamok.kode.data.api.ApiService
import com.icecreamok.kode.data.model.users.UsersResponse
import retrofit2.Response
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UsersRepository {
    companion object {
        private const val headerSuccess = "code=200, example=success"
        private const val headerGeneric = "code=200, dynamic=true"
        private const val headerHttp500 = "code=500, example=error-500"
    }

    override suspend fun getUsers(expectedResponse: RESPONSE): Response<UsersResponse> {
        val preferHeader = getCurrentHeader(expectedResponse)
        return apiService.getUsers(preferHeader)
    }

    private fun getCurrentHeader(expectedResponse: RESPONSE) =
        when (expectedResponse) {
            RESPONSE.SUCCESS -> headerSuccess
            RESPONSE.GENERIC -> headerGeneric
            RESPONSE.HTTP_500 -> headerHttp500
        }
}