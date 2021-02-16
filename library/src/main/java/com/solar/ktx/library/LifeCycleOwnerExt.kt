package com.solar.ktx.library

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LifecycleOwner.observe(liveData: LiveData<out T>, onChanged: (v: T) -> Unit) {
    liveData.observe(this, { onChanged(it) })
}