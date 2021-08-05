package com.tejas.mobileshop.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutine {

    fun <T : Any> ioThenIO(work: suspend (() -> T?), callback: suspend ((T?) -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }
}