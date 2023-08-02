package com.icecreamok.kode.domain

data class UserDto(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val tag: String,
    val category: String,
    val birthday: String,
    val age: String,
    val phone: String
)
