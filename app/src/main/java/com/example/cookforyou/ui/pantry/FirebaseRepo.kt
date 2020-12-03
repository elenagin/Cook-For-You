package com.example.cookforyou.ui.pantry

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: FirebaseRepo stores database methods for retrieving pantry information
 */
class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: getPantryItem gets pantry item from database
     */
    fun getPantryItem(item: String): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("pantries")
            .whereEqualTo("item", item)
            .get()
    }

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: getPantryItems gets pantry items from database
     */
    fun getPantryItems(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("pantries").limit(10)
            .get()
    }

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: deletePantryItem deletes pantry items from database
     */
    fun deletePantryItem(itemID: String): Task<Void> {
        return firebaseFirestore
            .collection("pantries")
            .document(itemID)
            .delete()
    }
}