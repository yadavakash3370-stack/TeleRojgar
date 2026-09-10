package com.kaka.telegram

import io.github.tdlibandroid.ktx.TdClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AuthManager(
    private val client: TdClient
) {

    private val scope = CoroutineScope(Dispatchers.IO)
    private var authJob: Job? = null

    fun start(
        onState: (String) -> Unit
    ) {
        authJob?.cancel()

        authJob = scope.launch {
            client.updates.collectLatest { update ->

                onState(
                    update.toString()
                )
            }
        }
    }

    fun stop() {
        authJob?.cancel()
        authJob = null
    }
}
