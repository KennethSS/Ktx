package com.solar.ktx.library.component

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.lifecycle.LiveData
import com.solar.ktx.library.REQUEST_CODE_PERMISSION



//region Permission
fun Activity.requestLocationPermission(requestCode: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION), requestCode)
    }
}

fun Activity.requestPermission(permissions: Array<String>, onIsNotDangerPermission: () -> Unit = { }) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(permissions, REQUEST_CODE_PERMISSION)
    } else {
        onIsNotDangerPermission()
    }
}

//endregion

fun Activity.intentToCall(telNum: String) {
    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telNum")))
}

fun <T> Activity.observe(liveData: LiveData<out T>, onChanged: (v: T) -> Unit) {
    this.observe(liveData, onChanged)
}


inline fun <reified T> Context.start(vararg pairs: Pair<String, Any>) {
    startActivity(Intent(this, T::class.java).apply {
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

// Activity related
inline fun <reified  T : Any> Activity.getValue(
    key : String, default : T? = null) = lazy{
    val value = intent?.extras?.get(key)
    if (value is T) value else default
}

inline fun <reified  T : Any> Activity.getValueNonNull(
    key : String, default : T? = null) = lazy{
    val value = intent?.extras?.get(key)
    requireNotNull((if (value is T) value else default)){key}
}