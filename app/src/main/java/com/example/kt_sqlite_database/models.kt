package com.example.kt_sqlite_database

data class ToDo(var Task: String, var Done: Boolean) {
    override fun toString(): String {
        return this.Task
    }
}