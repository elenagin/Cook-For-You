package com.example.cookforyou.ui.recipes

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getRecipe(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("recipes")
            .orderBy("name")
            .get()
    }
}