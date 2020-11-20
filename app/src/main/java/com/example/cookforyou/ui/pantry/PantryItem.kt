package com.example.cookforyou.ui.pantry

import com.google.firebase.database.DataSnapshot

class PantryItem(snapshot: DataSnapshot){
    lateinit var name: String
    lateinit var email: String
    lateinit var userID: String

    init {
        try {
            val data: HashMap<String, Any> = snapshot.value as HashMap<String, Any>
            userID = snapshot.key ?: ""
            name = data["name"] as String
            email = data["email"] as String
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}