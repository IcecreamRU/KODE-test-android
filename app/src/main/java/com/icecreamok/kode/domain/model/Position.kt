package com.icecreamok.kode.domain.model

sealed class Position {
    object All : Position()
    class NamedPosition(name: String) : Position()
}
