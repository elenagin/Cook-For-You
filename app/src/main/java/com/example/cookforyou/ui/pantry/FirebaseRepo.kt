package com.example.cookforyou.ui.pantry

import android.util.Log
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
     * description: getPantryItem gets pantry items from database
     */
    fun getPantryItem(item: String): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("pantries")
            .whereEqualTo("item", item)
            .get()
    }

    fun getPantryItems(): Task<QuerySnapshot>{
        return firebaseFirestore
            .collection("pantries")
            .get()
    }

    fun deletePantryItem(itemID: String): Task<Void> {
        return firebaseFirestore
            .collection("pantries")
            .document(itemID)
            .delete()
    }
}