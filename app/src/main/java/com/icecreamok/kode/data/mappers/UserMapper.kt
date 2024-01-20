package com.icecreamok.kode.data.mappers

import com.icecreamok.kode.data.model.users.UserDto
import com.icecreamok.kode.domain.model.UserItem

class UserMapper {
    fun userDtoToUserItem(userDto: UserDto): UserItem {
        return UserItem(
            avatarUrl = userDto.avatarUrl,
            birthday = userDto.birthday,
            department = userDto.department,
            firstName = userDto.firstName,
            id = userDto.id,
            lastName = userDto.lastName,
            phone = userDto.phone,
            position = userDto.position,
            userTag = userDto.userTag
        )
    }

    fun userDtoListToUserItemList(userDtoList: List<UserDto>): List<UserItem> {
        val result = arrayListOf<UserItem>()
        userDtoList.forEach {
            result.add(userDtoToUserItem(it))
        }
        return result
    }
}