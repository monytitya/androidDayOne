package com.example.androidsoneday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidsoneday.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // FragmentA is already added via android:name in the layout.
        // If it wasn't, we would add it here:
        /*
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentA())
                .commit()
        }
        */
    }
}