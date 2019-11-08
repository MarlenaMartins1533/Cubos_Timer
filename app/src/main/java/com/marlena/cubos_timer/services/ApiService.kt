package com.marlena.cubos_timer.services

import com.marlena.cubos_timer.repostory.TimeZoneRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://worldtimeapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService() = retrofit.create(TimeZoneRepository::class.java)
}