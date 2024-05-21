package com.example.legendaryquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.legendaryquiz.databinding.ActivitySpalshBinding

class spalsh : AppCompatActivity() {
    lateinit var binding: ActivitySpalshBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySpalshBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
              var intent = Intent(this,MainActivity::class.java)
              startActivity(intent)
             finish()
        },2000)
    }
}