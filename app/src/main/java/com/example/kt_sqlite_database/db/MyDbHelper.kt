package com.example.kt_sqlite_database.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    "todos.db",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TodoTable.CMD_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}

