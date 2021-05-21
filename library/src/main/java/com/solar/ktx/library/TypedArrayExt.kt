package com.solar.ktx.library

import android.content.res.TypedArray
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract

@UseExperimental(ExperimentalContracts::class)
inline fun TypedArray.use(block: TypedArray.() -> Unit) {
  contract { callsInPlace(block, EXACTLY_ONCE) }
  try {
    block()
  } finally {
    recycle()
  }
}