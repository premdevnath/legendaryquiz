package com.example.legendaryquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legendaryquiz.databinding.ActivityQuizBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class quizA : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding
    private lateinit var list:ArrayList<rvmodal>
    private var count:Int=0
    private var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list=ArrayList<rvmodal>()

        //or fire base me hane pahle hi value dal di thi
                          //***[yaha hum firestore se value ko nikal(get) rahe hai]
        //r1 (iske liye yaha pahle path diya data kaha hai fir get() ka use kiya data nikale ne ke liye)
        Firebase.firestore.collection("quiz")
            .get().addOnSuccessListener{
                dot->

                //r2(yaha hamene jo list banai uuse clear kiya taki data dublicate na ho)
                list.clear()

                //r3(yaha hame firestore se data nikal ke uuse vahi dot me dala tha to yaha vo dot ye value ko i varible me liya)
                for(i in dot.documents)
                {
                    //i me jo data hai uuse rv modal type ka banaya
                    var rvmodal=i.toObject(rvmodal::class.java)
                    //fir rvmodal nke data ko list me data  [yaha hame list me hi value dalni hai kisi recylcer view ya list view ya grid view me nhi to yaha adpetr bhi nhi hai]
                    list.add(rvmodal!!)
                }
                //r*(r8 me count ki vaule 1 ho gai to list me get(0) me jo data tha uuse nikalene ke leye ye kiya)
                //iise yaha lagay taki suruvat me pahle qution or option me list me get(0) me jo bhi vo print ho jaye taki r5 me usne clik kar sake
                binding.qution.setText(list.get(0).qution)
                binding.option1.setText(list.get(0).option1)
                binding.option2.setText(list.get(0).option2)
                binding.option3.setText(list.get(0).option3)
                binding.option4.setText(list.get(0).option4)
            }


            //***[yaha option ko cun rahe hai]fir jis bhi option ko chunte hai uuse nextdata fun me math karate hai

        //r5(yaha jaise hi button par click kara to us button par jo text (vaule) hogi uuse hum nextdata() fun me bhej rahe hai )
        binding.option1.setOnClickListener()
        {
          nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener()
        {
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener()
        {
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener()
        {
            nextData(binding.option4.text.toString())
        }



    }
                //***[yaha sahi option match kara hai he ]

    // r6(ans ko chek or score dena yaha par ho rah hai
    // yaha jis bhi option par clik karenge us option ki value i me aayegi )

    private fun nextData(i: String) {
        //r7(yaha pahle count ka size 0 hai or list size jitne qution honge utna manlo 4[to jab tak count chota hoga tab tak ye ye chalenga]
      if(count<list.size)
      {
          //yaha pahle get() ka use karke qution ki positon dekhi[yani list.get(0) yani qution 1]
          //fir ans ki value ko i me jo value aayi uuse amth karaya agar euals hoga to score ka size bad jayega)r7
          if(list.get(count).ans.equals(i))
          // yaha ans me value fire sote me diya hai hamne
              {
              score++
          }
      }
        //r8(yaha count ko badaya fir vapas if(count<list.size) me jayega jab tak count ka size chota hai hai)
       count++

                   //***[yaha se result show hoga]
        //r9(score ka size list size se jayada ho gya yani qution khatam to score ko result.kt  me bhej ke show kara do )
        if(count>=list.size)
        {
            val intent = Intent(this,result::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }

            //[[note:-yaha r8 me count bada to ab count ki value 1 ho gai to list se get(0) nhi ho payega isliye r* me get(0) position me jo bhi hai uuse qution and anser me set kiya)]]


                     //***[yaha oution ans option set kar rhe hai]
        //r10(or count ka size abhi list size se chota hi a yani ye else calega
        //***[isme hum qution or answer ko list se get karke unko apne app me set kar rhe hai]
        //to yaha get(conut) yani pahle get(1) hoga to app me qution or option me 0 potion vale qution or option set honge
        // fir count ki value 1 hogi to get(2) to app me 1 potion vale qution and option set honge)r10
        else
        {
            binding.qution.setText(list.get(count).qution)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }

    }
}