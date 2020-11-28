package com.example.cookforyou.ui.pantry

import androidx.lifecycle.ViewModel

private const val TAG = "PantryViewModel"

/**
 * Creates random items for view model
 */
class PantryViewModel : ViewModel() {
    //findview
    /*var db = FirebaseFirestore.getInstance()
    private val docRef = db.collection("pantries").document("0XYZS3PgeIW9Cw6hAvgx")

    private val textToReturn = getItemsFromFirebase()
    val text: LiveData<String> = textToReturn


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
    }*/
}