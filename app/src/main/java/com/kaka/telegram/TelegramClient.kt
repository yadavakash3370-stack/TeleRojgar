package com.kaka.telegram

import android.content.Context
import io.github.tdlibandroid.ktx.TdClient

class TelegramClient(
    private val context: Context
) {

    lateinit var client: TdClient
        private set

    fun initialize() {

        System.loadLibrary("tdjni")

        val databasePath =
            context.filesDir.absolutePath + "/tdlib"

        client = TdClient(
            filesDir = databasePath,
            verbosityLevel = 1,
            apiId = BuildConfig.TELEGRAM_API_ID,
            apiHash = BuildConfig.TELEGRAM_API_HASH
        )

        client.init()
    }
}
