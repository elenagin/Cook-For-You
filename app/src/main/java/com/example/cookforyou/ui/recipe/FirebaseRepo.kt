package com.example.cookforyou.ui.recipe

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: FirebaseRepo stores database methods for retrieving recipes information
 */
class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: getCurrentRecipe gets current recipe from database
     */
    fun getCurrentRecipe(name: String): Task<QuerySnapshot> {
        return firebaseFirestore
            .collection("recipes")
            .whereEqualTo("name", name)
            .get()
    }
}