package com.shruti.ListBaseAdapterApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class Listadapter( var item: ArrayList<Student>,var activityInterface: ActivityInterface) : BaseAdapter() {
    override fun getCount(): Int {
       return item.size
    }

    override fun getItem(p0: Int): Any {
       return 1
    }

    override fun getItemId(p0: Int): Long {
        return 1L
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
       var view = LayoutInflater.from(p2?.context).inflate(R.layout.item_adapter_view, p2,false)
        var name = view.findViewById<TextView>(R.id.tvname)
        var roll = view.findViewById<TextView>(R.id.tvroll)
        var edit = view.findViewById<Button>(R.id.btedit)
        var delete = view.findViewById<Button>(R.id.btdel)
        name.setText(item[p0].name)
        roll.setText(item[p0].rollnumber.toString())
        edit.setOnClickListener {
            activityInterface.onUpdateclick(item[p0], p0)
        }
        delete.setOnClickListener {
            activityInterface.onDeleteclick(item[p0],p0)
        }
        return view
    }
}