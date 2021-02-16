package com.solar.ktx.library

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData


fun <T>Fragment.observe(liveData: LiveData<out T>, onChanged: (v: T) -> Unit) {
    viewLifecycleOwner.observe(liveData, onChanged)
}