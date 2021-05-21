package com.solar.ktx.library

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData


fun <T>Fragment.observe(liveData: LiveData<out T>, onChanged: (v: T) -> Unit) {
    viewLifecycleOwner.observe(liveData, onChanged)
}

// Fragment related
inline fun <reified T: Any> Fragment.getValue(lable: String, defaultvalue: T? = null) = lazy {
    val value = arguments?.get(lable)
    if (value is T) value else defaultvalue
}

inline fun <reified T: Any> Fragment.getValueNonNull(lable: String, defaultvalue: T? = null) = lazy {
    val value = arguments?.get(lable)
    requireNotNull(if (value is T) value else defaultvalue) { lable }
}