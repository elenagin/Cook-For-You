package com.example.cookforyou.ui.myRecipes

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
     * description: getRecipe gets recipes from database
     */
    fun getRecipe(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("recipes")
            .orderBy("name")
            .get()
    }
}