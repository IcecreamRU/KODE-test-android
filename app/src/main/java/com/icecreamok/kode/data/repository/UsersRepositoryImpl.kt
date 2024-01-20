package com.icecreamok.kode.data.repository

import com.icecreamok.kode.data.api.ApiService
import com.icecreamok.kode.data.model.users.UserDto
import com.icecreamok.kode.domain.ExpectedResponse
import com.icecreamok.kode.domain.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UsersRepository {

    private var cachedUserList: List<UserDto> = emptyList()

    override suspend fun getUsers(expectedResponse: ExpectedResponse): Result<List<UserDto>> {
        if (cachedUserList.isNotEmpty()) {
            return Result.success(cachedUserList)
        }

        var error: String? = null

        val preferHeader = getCurrentHeader(expectedResponse)

        apiService.getUsers(preferHeader).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    cachedUserList = body.items
                } ?: {
                    error = "Ошибка ${response.code()}"
                }
            } else {
                error = "Ошибка ${response.code()}"
            }
        }

        return if (!error.isNullOrBlank()) {
            Result.failure(Throwable(message = error))
        } else {
            Result.success(cachedUserList)
        }
    }

    override suspend fun getCategories(expectedResponse: ExpectedResponse): Result<List<String>> {
        TODO("Not yet implemented")
    }

    private fun getCurrentHeader(expectedResponse: ExpectedResponse) =
        when (expectedResponse) {
            ExpectedResponse.SUCCESS -> headerSuccess
            ExpectedResponse.GENERIC -> headerGeneric
            ExpectedResponse.HTTP_500 -> headerHttp500
        }

    companion object {
        private const val headerSuccess = "code=200, example=success"
        private const val headerGeneric = "code=200, dynamic=true"
        private const val headerHttp500 = "code=500, example=error-500"
    }
}

