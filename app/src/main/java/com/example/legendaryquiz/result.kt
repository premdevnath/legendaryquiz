package com.example.legendaryquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legendaryquiz.databinding.ActivityResultBinding

class result : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //***[jaba count ki value list size se jayada ho jayegi yani qution khata to score batana hai to vo yaha bataya ja rha hai
        //r11(yaha text value me vaha se intent ne value baji use get kiya or kuki value int vali hai to getInt lagaya)
        binding.score.setText("Your Score is:${intent.getIntExtra("SCORE",0)}")
    }
}