package com.example.cookforyou.ui.pantry

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getPantryItem(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("pantries")
            .orderBy("item")
            .get()
    }
}