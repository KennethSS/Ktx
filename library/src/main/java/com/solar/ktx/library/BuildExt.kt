package com.solar.ktx.library

fun atLeastOreo() = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O
fun atLeastPie() = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P
fun atLeast10() = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q
fun atLeast11() = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R