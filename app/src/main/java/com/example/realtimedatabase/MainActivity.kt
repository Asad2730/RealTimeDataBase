package com.example.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() , OnClickListener{

    private var insert:Button? = null
   private  var view:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insert = findViewById(R.id.insert)
        view = findViewById(R.id.View)

        insert?.setOnClickListener (this)
        view?.setOnClickListener(this)
     }

    override fun onClick(p0: View?) {

        when(p0?.id){

            R.id.insert -> {
               startActivity(Intent(this,Insert::class.java))
            }

            R.id.View -> {
                startActivity(Intent(this,Show::class.java))
            }
        }

    }
}