package com.example.androidsoneday.components.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidsoneday.R
import com.example.androidsoneday.databinding.ActivityMainBinding
import com.example.androidsoneday.ui.FragmentA
import com.example.androidsoneday.materialui.MaterialShowcaseFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_components -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentA())
                        .commit()
                    true
                }
                R.id.nav_material -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MaterialShowcaseFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}