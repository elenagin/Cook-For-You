package com.example.cookforyou.ui.discover

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

/**
 * author: Elena Ginebra Z.
 * date: 01 Dec 2020
 * description: FirebaseRepo stores database methods for retrieving recipes information
 */
class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: getRecipes gets recipes from database
     */
    fun getIngredientOneRecipes(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("recipes")
            .whereIn("ingredient1", listOf("Toast", "Blueberries", "Banana", "Salmon", "Egg", "Chili sauce", "Sugar", "Fresh scallions"))
            .get()
    }

    fun getIngredientTwoRecipes(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("recipes")
            .whereIn("ingredient2", listOf("Toast", "Blueberries", "Banana", "Salmon", "Egg", "Chili sauce", "Sugar", "Fresh scallions"))
            .get()
    }

    fun getIngredientThreeRecipes(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("recipes")
            .whereIn("ingredient3", listOf("Toast", "Blueberries", "Banana", "Salmon", "Egg", "Chili sauce", "Sugar", "Fresh scallions"))
            .get()
    }
}