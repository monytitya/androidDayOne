package com.example.androidsoneday

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: StopwatchViewModel by viewModels()
    private val tag = "LifecycleDemo"   // camelCase ដើម្បីជៀស warning

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, "onCreate called")

        val tvTimer = findViewById<TextView>(R.id.tvTimer)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnReset = findViewById<Button>(R.id.btnReset)

        tvTimer.text = viewModel.seconds.toString()

        viewModel.onTick = { sec ->
            runOnUiThread { tvTimer.text = sec.toString() }
        }

        btnStart.setOnClickListener { viewModel.start() }
        btnPause.setOnClickListener { viewModel.pause() }
        btnReset.setOnClickListener { viewModel.reset() }
    }

    override fun onStart() { super.onStart(); Log.d(tag, "onStart called") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume called") }
    override fun onPause() { super.onPause(); Log.d(tag, "onPause called") }
    override fun onStop() { super.onStop(); Log.d(tag, "onStop called") }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy called - isChangingConfigurations = $isChangingConfigurations")
    }
}