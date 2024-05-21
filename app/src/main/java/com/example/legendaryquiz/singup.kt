package com.example.legendaryquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.legendaryquiz.databinding.ActivitySingupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class singup : AppCompatActivity() {
    lateinit var binding: ActivitySingupBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=Firebase.auth
        binding.singin.setOnClickListener(){
            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.register.setOnClickListener()
        {
            var email=binding.email.text.toString()
            var name=binding.name.text.toString()
            var pass=binding.password.text.toString()
            var repass=binding.repassword.text.toString()
            if(email.isEmpty()||name.isEmpty()||pass.isEmpty()||repass.isEmpty())
            {
                Toast.makeText(this, "please fill frist", Toast.LENGTH_SHORT).show()
            }
            else if(pass!=repass)
            {
                Toast.makeText(this, "please fill both are frist", Toast.LENGTH_SHORT).show()
            }
            else
            {
             auth.createUserWithEmailAndPassword(email,pass)
                 .addOnCompleteListener { task->
                     if(task.isSuccessful) {
                         Toast.makeText(this, "register sucessfull", Toast.LENGTH_SHORT).show()
                         var intent=Intent(this,MainActivity::class.java)
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