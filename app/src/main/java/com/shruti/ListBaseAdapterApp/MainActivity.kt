package com.shruti.ListBaseAdapterApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import com.shruti.ListBaseAdapterApp.databinding.ActivityMainBinding
import com.shruti.ListBaseAdapterApp.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity(), ActivityInterface {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Listadapter
    var item = arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = Listadapter(item, this)
        binding.list.adapter = adapter
        item.add(Student("Shruti Sharma", 48))
        item.add(Student("Ridham Sharma", 37))
        item.add(Student("Roma Kumari", 40))
        binding.fab.setOnClickListener {
            var dialog = Dialog(this)
            /*var roll = dialog.findViewById<EditText>(R.id.etname)
            var name = dialog.findViewById<EditText>(R.id.etrollnumber)
            var add = dialog.findViewById<Button>(R.id.btadd)*/
            var dialogBinding = CustomdialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.btadd.setOnClickListener {
                if (dialogBinding.etrollnumber.text.toString().isNullOrEmpty()) {
                    dialogBinding.etrollnumber.error = ("Enter roll number")
                } else if (dialogBinding.etname.text.toString().isNullOrEmpty()) {
                    dialogBinding.etname.error = "Enter name"
                } else {
                    System.out.println("in else condtion")
                    item.add(
                        Student(
                            dialogBinding.etname.text.toString(),
                            dialogBinding.etrollnumber.text.toString().toInt()
                        )
                    )
                    dialog.dismiss()
                    adapter.notifyDataSetChanged()
                }
            }
            dialog.show()
        }
    }

    override fun onDeleteclick(student: Student, position: Int) {
        item.removeAt(position)
        adapter.notifyDataSetChanged()
    }

    override fun onUpdateclick(student: Student, position: Int) {
        var dialog = Dialog(this)
        var dialogBinding = CustomdialogBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.btadd.setOnClickListener {
            if (dialogBinding.etrollnumber.text.toString().isNullOrEmpty()) {
                dialogBinding.etrollnumber.error = ("Enter roll number")
            } else if (dialogBinding.etname.text.toString().isNullOrEmpty()) {
                dialogBinding.etname.error = "Enter name"
            } else {
                System.out.println("in else condtion")
                item.set(position, Student(dialogBinding.etname.text.toString(), dialogBinding.etrollnumber.text.toString().toInt()
                    )
                )
                dialog.dismiss()
                adapter.notifyDataSetChanged()

            }
        }
    dialog.show()
    }

}
