package com.example.cookforyou.ui.home

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

/**
 * author: Elena Ginebra Z.
 * date: 28 Nov 2020
 * description: FirebaseRepo stores database methods for retrieving recipes information
 */
class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    /**
     * author: Elena Ginebra Z.
     * date: 28 Nov 2020
     * description: getRandomRecipeName gets recipes from database
     */
    fun getRandomRecipeName(id: Int): Task<QuerySnapshot> {
        return firebaseFirestore
            .collection("recipes")
            .whereEqualTo("id", id)
            .get()
    }
}