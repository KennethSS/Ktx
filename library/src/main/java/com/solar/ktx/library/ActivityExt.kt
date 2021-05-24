package com.solar.ktx.library

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData



//region Permission
fun Activity.requestLocationPermission(requestCode: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        requestPermissions(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION), requestCode)
    }
}

fun Activity.requestPermission(permissions: Array<String>) = requestPermissions(permissions, REQUEST_CODE_PERMISSION)

//endregion

fun Activity.intentToCall(telNum: String) {
    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telNum")))
}

fun <T> Activity.observe(liveData: LiveData<out T>, onChanged: (v: T) -> Unit) {
    this.observe(liveData, onChanged)
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