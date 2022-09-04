package com.example.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.*
import java.util.*

class Show : AppCompatActivity() {

    private var ref:DatabaseReference? = null
    var lv:ListView? = null
   lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)


        lv = findViewById(R.id.list)

        load()

        lv?.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this,UpdateDelete::class.java)
            intent.putExtra(Helper.Id,i)
            startActivityForResult(intent,Helper.requestCode)
        }

    }

    private fun load(){
        //to clear previous items //avoid displaying items twice when new record is inserted
        Helper.items.clear()

         ref = FirebaseDatabase.getInstance().reference.child(Helper.table)
       val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for(i:DataSnapshot in snapshot.children){

                   var d = i.getValue(DataClass::class.java)
                    if (d != null) {
                        Helper.items.add(d)
                        adapter = MyAdapter(applicationContext,R.layout.row,Helper.items)
                        lv?.adapter = adapter
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }

        ref?.addValueEventListener(listener)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Helper.requestCode){

            if(resultCode == RESULT_OK){
                //adapter.notifyDataSetChanged()
                load()
            }
        }
    }
}