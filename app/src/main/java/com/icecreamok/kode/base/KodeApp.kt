package com.icecreamok.kode.base

import android.app.Application
import com.icecreamok.kode.di.DaggerApplicationComponent

class KodeApp : Application() {
    val appComponent = DaggerApplicationComponent.create()
}