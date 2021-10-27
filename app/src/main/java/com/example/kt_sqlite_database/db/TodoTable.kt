package com.example.kt_sqlite_database.db

import android.database.sqlite.SQLiteDatabase
import androidx.core.content.contentValuesOf
import com.example.kt_sqlite_database.ToDo

object TodoTable {
    val TABLE_NAME = "todos"

    object Colums {
        var ID = "id"
        var TASK = "task"
        var DONE = "done"
    }

    val CMD_CREATE_TABLE = """"CREATE TABLE IF NOT EXISTS $TABLE_NAME
        |(
        |${Colums.ID}INTEGER PRIMARY KEY AUTOINCREMENT;
        |${Colums.TASK}TEXT,
        |${Colums.DONE}BOOLEAN
        |);
    """.trimMargin()

    fun insertTodo(db: SQLiteDatabase, toDo: ToDo) {
        val row = contentValuesOf()
        row.put(Colums.TASK, toDo.Task)
        row.put(Colums.DONE, toDo.Task)

        db.insert(TABLE_NAME, null, row)

    }

    fun getAllTodos(db: SQLiteDatabase) {

        val todos = ArrayList<ToDo>()
        var c = db.query(
            TABLE_NAME,
            arrayOf(Colums.ID, Colums.TASK, Colums.DONE),
            null, null, null, null, null
        )

        while (c.moveToNext()) {
            val todo = ToDo(
                c.getString(1), c.getInt(2) == 1
            )
            todos.add(todo)
        }
    }

}