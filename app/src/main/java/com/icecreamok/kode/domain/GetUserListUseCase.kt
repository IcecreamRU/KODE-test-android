package com.icecreamok.kode.domain

class GetUserListUseCase(private val userListRepository: UserListRepository) {

    /**
     * This function returns a list of users of type `List<UserDto>`. It takes optional parameters `userTag` and `searchInput` of type `String`, as well as a parameter `userSortType` of type `UserSortType`, which is set to `UserSortType.ALPHABETICAL` by default.
     *
     * @param userTag the user tag, can be empty
     * @param searchInput the search input string, can be empty
     * @param userSortType the user sort type, defaults to `UserSortType.ALPHABETICAL`
     * @return the list of users of type `List<UserDto>`
     *
     * @see UserDto
     * @see UserSortType
     */
    fun getUserList(
        userTag: String?,
        searchInput: String?,
        userSortType: UserSortType = UserSortType.ALPHABETICAL
    ): List<UserDto> {
        return userListRepository.getUserList(userTag, searchInput, userSortType)
    }
}