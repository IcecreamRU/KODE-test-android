package com.icecreamok.kode.domain

interface UserListRepository {
    fun loadUserListFromServer()
    fun getUserList(
        userTag: String?,
        searchInput: String?,
        userSortType: UserSortType
    ): List<UserDto>
}