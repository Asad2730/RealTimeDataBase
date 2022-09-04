package com.example.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.*

class UpdateDelete : AppCompatActivity() {

    private var name:EditText? = null
     private var no:EditText? = null
    private var update:Button? = null
    private var delete:Button? = null
   private var id:Int? = null
   private var db:DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)


        name = findViewById(R.id.ud_name)
        no = findViewById(R.id.ud_no)

        update = findViewById(R.id.update)
        delete = findViewById(R.id.delete)

        id = intent.getIntExtra(Helper.Id,0)

        db =  FirebaseDatabase.getInstance().reference.child(Helper.table).child(Helper.items[id!!].id.toString())

        name?.setText(Helper.items[id!!].name.toString())
        no?.setText(Helper.items[id!!].gender.toString())

        update?.setOnClickListener {
            updateDB()
           setResult(RESULT_OK)
           this.finish()
        }

        delete?.setOnClickListener {
            deleteDB()
            setResult(RESULT_OK)
            this.finish()
        }

    }


    private fun updateDB(){

        val data = DataClass(Helper.items[id!!].id.toString(),Helper.items[id!!].name.toString(),Helper.items[id!!].gender.toString())
        db?.setValue(data)
       Toast.makeText(this,"Updated",Toast.LENGTH_LONG).show()
    }


    private fun deleteDB(){

      db?.removeValue()
    }
}