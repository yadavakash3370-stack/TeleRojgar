 package com.kaka.telegram

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var telegramClient: TelegramClient
    private lateinit var authManager: AuthManager

    private lateinit var statusText: TextView
    private lateinit var inputField: EditText
    private lateinit var actionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        inputField = findViewById(R.id.inputField)
        actionButton = findViewById(R.id.actionButton)

        telegramClient = TelegramClient(this)

        try {
            telegramClient.initialize()

            authManager = AuthManager(
                telegramClient.client
            )

            authManager.start { state ->
                runOnUiThread {
                    statusText.text = state
                }
            }

        } catch (e: Exception) {
            statusText.text =
                "Telegram initialization failed\n${e.message}"
        }
    }

    override fun onDestroy() {
        if (::authManager.isInitialized) {
            authManager.stop()
        }

        super.onDestroy()
    }
}
