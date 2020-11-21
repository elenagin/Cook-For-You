package com.example.cookforyou.ui.pantry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "PantryViewModel"

/**
 * Creates random items for view model
 */
class PantryViewModel : ViewModel() {
    var db = FirebaseFirestore.getInstance()
    private val docRef = db.collection("pantries").document("0XYZS3PgeIW9Cw6hAvgx")

    private val numb = getItemsFromFirebase()
    val text: LiveData<String> = numb


    private fun getItemsFromFirebase(): MutableLiveData<String> {
        return MutableLiveData<String>().apply {
            docRef.get().addOnSuccessListener { document ->
                if (document != null) {
                    value = document.get("item").toString()
                } else {
                    Log.d(TAG, "No such document")
                }
            }
        }
    }
}