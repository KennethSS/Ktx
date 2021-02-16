package com.solar.ktx.library

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.View

fun Activity.requestLocationPermission(requestCode: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION), requestCode)
    }
}


fun Activity.intentToCall(telNum: String) {
    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telNum")))
}


inline fun <reified T> View.startActivity(vararg pairs: Pair<String, Any>) {
    context.startActivity(Intent(context, T::class.java).apply {
        for ((key, value) in pairs) {
            when(value) {
                is Boolean -> putExtra(key, value)
                is Byte -> putExtra(key, value)
                is Char -> putExtra(key, value)
                is Double -> putExtra(key, value)
                is Float -> putExtra(key, value)
                is Int -> putExtra(key, value)
                is Long -> putExtra(key, value)
                is Short -> putExtra(key, value)
            }
        }
    })
}