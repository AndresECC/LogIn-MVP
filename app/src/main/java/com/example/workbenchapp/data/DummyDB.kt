package com.example.workbenchapp.data

import com.example.workbenchapp.model.User

object DummyDB {
    private val users: MutableList<User> = mutableListOf(User("admin", "Pass"))


    fun addUser(user: User) {
        users.add(user)
    }

    fun getUser(username: String): User? {
        return users.find { it.name == username }
    }

    fun getAllUsers(): List<User> {
        return users
    }
}