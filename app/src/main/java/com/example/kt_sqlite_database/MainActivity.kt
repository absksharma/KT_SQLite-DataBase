package com.example.kt_sqlite_database

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val todos = ArrayList<String>()

    private lateinit var btnAdd: Button
    private lateinit var etNewToDo: EditText
    private lateinit var lvNotes: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btnAdd)
        etNewToDo = findViewById(R.id.etNewToDo)
        lvNotes = findViewById(R.id.lvToDo)

        val todoAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                todos
            )

        lvNotes.adapter = todoAdapter

        btnAdd.setOnClickListener {
            val newTodo = etNewToDo.text.toString()
            todos.add(newTodo)
            todoAdapter.notifyDataSetChanged()
        }
    }
}