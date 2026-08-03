package com.example.androidsoneday.components.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class ExampleService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
}