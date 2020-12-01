package com.example.cookforyou.ui.recipe

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
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
     * description: getRecipe gets recipes from database
     */
    fun getRecipes(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("recipes")
            .orderBy("name")
            .get()
    }

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: getCurrentRecipe gets current recipe from database
     */
    fun getCurrentRecipe(id: String): Task<DocumentSnapshot> {
        return firebaseFirestore
            .collection("recipes")
            .document(id)
            .get()
    }
}