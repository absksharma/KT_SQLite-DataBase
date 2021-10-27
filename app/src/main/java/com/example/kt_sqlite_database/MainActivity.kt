package com.example.kt_sqlite_database

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.kt_sqlite_database.db.MyDbHelper
import com.example.kt_sqlite_database.db.TodoTable

class MainActivity : AppCompatActivity() {

    private val todos = ArrayList<ToDo>()

    private lateinit var btnAdd: Button
    private lateinit var etNewToDo: EditText
    private lateinit var lvNotes: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btnAdd)
        etNewToDo = findViewById(R.id.etNewToDo)
        lvNotes = findViewById(R.id.lvToDo)

        val db = MyDbHelper(this).writableDatabase

        val todoAdapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            todos
        )

        fun refreshedTodoList() {
            val toDoList = TodoTable.getAllTodos(db)
            todos.clear()
            todos.addAll(toDoList)
        }
        lvNotes.adapter = todoAdapter

        btnAdd.setOnClickListener {
            val newTodo = ToDo(
                etNewToDo.text.toString(),
                false
            )
            TodoTable.insertTodo(db, newTodo)
            refreshedTodoList()
        }
    }
}