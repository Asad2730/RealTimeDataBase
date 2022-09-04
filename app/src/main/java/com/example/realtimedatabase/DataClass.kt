package com.example.realtimedatabase

import com.google.firebase.database.IgnoreExtraProperties

class DataClass {

     var id:String? = null
     var name:String? = null
     var gender:String? = null


  constructor(){

  }


    public constructor(id:String, name:String,gender:String){

          this.id = id
          this.name = name
           this.gender = gender
    }

}