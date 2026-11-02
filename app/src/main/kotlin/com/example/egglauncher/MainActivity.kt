package com.example.egglauncher

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val intent = Intent().apply {
                component = ComponentName(
                    "com.android.egg",
                    "com.android.egg.landroid.MainActivity"
                )
                // Запустити в новому завданні, щоб не тягнути наш стек
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        } catch (e: Exception) {
            // Якщо цільова активність недоступна — тихо закриваємось
            e.printStackTrace()
        } finally {
            // Закриваємось у будь-якому випадку
            finish()
        }
    }
}
