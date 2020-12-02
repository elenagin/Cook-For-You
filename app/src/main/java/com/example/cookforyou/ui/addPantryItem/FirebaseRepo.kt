package com.example.cookforyou.ui.addPantryItem

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

/**
 * author: Elena Ginebra Z.
 * date: 01 Dec 2020
 * description: FirebaseRepo stores database methods for retrieving recipes information
 */
class FirebaseRepo {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    /**
     * author: Elena Ginebra Z.
     * date: 01 Dec 2020
     * description: addToPantry adds pantry items to database
     */
    fun addToPantry(item: PantryItem): Task<Void> {
        val randomID: String = UUID.randomUUID().toString().substring(0, 19)
        return firebaseFirestore
            .collection("pantries")
            .document(randomID)
            .set(item)
            .addOnSuccessListener{}
    }
}