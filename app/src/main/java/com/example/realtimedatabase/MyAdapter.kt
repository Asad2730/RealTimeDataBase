package com.example.realtimedatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast

class MyAdapter(context: Context, resource: Int,private val list: MutableList<DataClass>):
    ArrayAdapter<DataClass>(context, resource, list)
{


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View = inflate.inflate(R.layout.row,parent,false)

        val id:TextView = view.findViewById(R.id.view_id)
        val name:TextView = view.findViewById(R.id.view_name)
        val gender:TextView = view.findViewById(R.id.view_gender)

        id.text = list[position].id.toString()
        name.text = list[position].name.toString()
        gender.text = list[position].gender.toString()


        return view
    }


}