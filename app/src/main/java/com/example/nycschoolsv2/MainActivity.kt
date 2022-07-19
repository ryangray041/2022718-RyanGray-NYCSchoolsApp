package com.example.nycschoolsv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nycschoolsv2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * Author: Ryan Gray
 * Coding Challenge: NYC Schools SAT Application
 * Date: 7/18/2022
 *
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}