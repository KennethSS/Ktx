package com.solar.ktx.library

import android.util.Patterns

fun String?.valid() : Boolean =
  this != null && !this.equals("null", true)
    && this.trim().isNotEmpty()

fun String.isValidEmail(): Boolean
  = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

/*
fun String.formatPhoneNumber(context: Context, region: String): String? {
  val phoneNumberKit = PhoneNumberUtil.createInstance(context)
  val number = phoneNumberKit.parse(this, region)
  if (!phoneNumberKit.isValidNumber(number))
    return null

  return phoneNumberKit.format(number, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
}*/
