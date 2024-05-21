package com.example.legendaryquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.legendaryquiz.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var auth: FirebaseAuth
    override fun onStart() {
        super.onStart()
        var currentuser=auth.currentUser
        if(currentuser!=null)
        {
            var intent=Intent(this,quizA::class.java)
            startActivity(intent)
        }
    }
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth
        binding.singup.setOnClickListener()
        {
            var intent= Intent(this,singup::class.java)
            startActivity(intent)
        }
        binding.login.setOnClickListener()
        {
            var email=binding.email.text.toString()
            var pass=binding.passwordd.text.toString()
            if(email.isEmpty()&&pass.isEmpty())
            {
                Toast.makeText(this, "fill both are frist", Toast.LENGTH_SHORT).show()
            }
            else
            {
               auth.signInWithEmailAndPassword(email,pass)
                   .addOnCompleteListener {task->
                       if(task.isSuccessful)
                       {
                           var intent=Intent(this,quizA::class.java)
                           startActivity(intent)
                       }
                       else
                       {
                           Toast.makeText(this, "faild", Toast.LENGTH_SHORT).show()
                       }
                   }
            }
        }
    }
}