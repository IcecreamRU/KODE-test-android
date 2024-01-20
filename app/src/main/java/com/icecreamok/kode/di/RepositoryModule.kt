package com.icecreamok.kode.di

import com.icecreamok.kode.data.api.ApiService
import com.icecreamok.kode.data.repository.UsersRepositoryImpl
import com.icecreamok.kode.domain.UsersRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun bindUsersRepository(apiService: ApiService): UsersRepository {
        return UsersRepositoryImpl(apiService)
    }
}