package com.example.caranimation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.caranimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCarOnClick()
    }

    private fun setCarOnClick() {
        binding.car.setOnClickListener {

        }
    }
}