package com.example.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Insert : AppCompatActivity() {

   private var gender:RadioGroup? = null
   private var id:EditText? = null
   private var name:EditText? = null

   private var save:Button? = null
   private var db:DatabaseReference? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        gender = findViewById(R.id.gender)
        id = findViewById(R.id.id)
        name = findViewById(R.id.name)
        save = findViewById(R.id.save)

        db = FirebaseDatabase.getInstance().reference

        save?.setOnClickListener {

           saveData()
           val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun saveData() {

        var gId:Int?= gender?.checkedRadioButtonId

        if(gId != -1 && gId != null){


            var rd:RadioButton = findViewById(gId)

            if(!name?.text.toString().isEmpty() &&
                    !id?.text.toString().isEmpty()){


                var genderValue:String = rd.text.toString()


                var data = DataClass(id?.text.toString(),name?.text.toString(),genderValue)

                db?.child(Helper.table)?.child(data.id.toString())?.setValue(data)

                Toast.makeText(this,"Save!",Toast.LENGTH_LONG).show()
            }
        }
    }
}