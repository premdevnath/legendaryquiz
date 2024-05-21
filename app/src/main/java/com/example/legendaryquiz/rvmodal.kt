package com.example.legendaryquiz

//firemodal me data ko store karne ke liye secandry construct jisme data dalte hai or primary constructor jo fire store ko chaia hota hai te
//ye data fire store lega or fire store me aise hi data dete hai
class rvmodal {
    var qution:String?=null
    var option1:String?=null
    var option2:String?=null
    var option3:String?=null
    var option4:String?=null
    var ans:String?=null
    constructor()
    constructor(qution:String?,option1:String?,option2:String?,option3:String?,option4:String?,ans:String?)
    {
        this.qution=qution
        this.option1=option1
        this.option2=option2
        this.option3=option3
        this.option4=option4
        this.ans=ans

    }
}