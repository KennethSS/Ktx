package com.solar.ktx.library

import android.util.TypedValue
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.annotation.MainThread

fun View.toast(msg: Any, length: Int = Toast.LENGTH_SHORT) {
    context.toast(msg, length)
}

fun View.enableRippleEffect() {
    context.theme.resolveAttribute(
        android.R.attr.selectableItemBackground,
        TypedValue(),
        true)
}

@MainThread
fun View.visible(duration: Long = 0L) {
    startAnimation(AlphaAnimation(0.0f, 1.0f).also {
        it.duration = duration
    })
    visibility = View.VISIBLE
}

@MainThread
fun View.gone(duration: Long = 0L) {
    startAnimation(AlphaAnimation(1.0f, 0.0f).also {
        it.duration = duration
        it.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) { }
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                visibility = View.GONE
            }
        })
    })
}