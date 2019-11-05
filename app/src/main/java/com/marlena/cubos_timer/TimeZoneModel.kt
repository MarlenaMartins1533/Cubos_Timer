package com.marlena.cubos_timer

data class TimeZoneModel (
    val name: String,
    val timezone: String = "GMT",
    val time: Int = 0,

    val name2: String = "-",
    val timezone2: String = "-"
)