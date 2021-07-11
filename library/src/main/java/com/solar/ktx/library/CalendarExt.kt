package com.solar.ktx.library

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.toDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREAN)
    return sdf.format(time).toString()
}