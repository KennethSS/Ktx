package com.solar.ktx.library.component

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.solar.ktx.library.REQUEST_CODE_PERMISSION
import com.solar.ktx.library.observe

//region Permission
fun Fragment.isPermissionGranted(permission: String): Boolean =
	ContextCompat.checkSelfPermission(
		requireContext(), permission
	) == PackageManager.PERMISSION_GRANTED

fun Fragment.requestPermission(permissions: Array<String>) =
	requestPermissions(permissions, REQUEST_CODE_PERMISSION)
//endregion

fun <T> Fragment.observe(
	liveData: LiveData<out T>,
	onChanged: (v: T) -> Unit
) {
	viewLifecycleOwner.observe(liveData, onChanged)
}

// Fragment related
inline fun <reified T : Any> Fragment.getValue(
	lable: String,
	defaultvalue: T? = null
) = lazy {
	val value = arguments?.get(lable)
	if (value is T) value else defaultvalue
}

inline fun <reified T : Any> Fragment.getValueNonNull(
	lable: String,
	defaultvalue: T? = null
) = lazy {
	val value = arguments?.get(lable)
	requireNotNull(if (value is T) value else defaultvalue) { lable }
}