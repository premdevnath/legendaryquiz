package com.example.legendaryquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legendaryquiz.databinding.ActivityQuizBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class quizep : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding
    lateinit var list:ArrayList<rvmodal>
    var count:Int=0
    var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list= ArrayList<rvmodal>()
        Firebase.firestore.collection("quiz")
            .get().addOnSuccessListener { dot->
                list.clear()
                for(i in dot.documents)
                {
                    var rvmodal=i.toObject(rvmodal::class.java)
                    list.add(rvmodal!!)
                }
                binding.qution.text=(list.get(0).qution)
                binding.option1.text=(list.get(0).option1)
                binding.option2.text=(list.get(0).option2)
                binding.option3.text=(list.get(0).option3)
                binding.option4.text=(list.get(0).option4)
            }
        binding.option1.setOnClickListener {
            getaciton(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            getaciton(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            getaciton(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            getaciton(binding.option4.text.toString())
        }

    }

    private fun getaciton(i: String) {
        if(count<list.size)
        {
            if(list.get(count).ans.equals(i))
            {
                score++
            }
        }
        count++
        if(count>=list.size)
        {
            var intent= Intent(this,result::class.java)
            startActivity(intent)
        }
        else
        {
            binding.qution.text=(list.get(count).qution)
            binding.option1.text=(list.get(count).option1)
            binding.option2.text=(list.get(count).option2)
            binding.option3.text=(list.get(count).option3)
            binding.option4.text=(list.get(count).option4)
        }

    }
}