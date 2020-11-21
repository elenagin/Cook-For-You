package com.example.cookforyou.ui.settings

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "SettingsViewModel"

class SettingsViewModel : ViewModel() {
    var db = FirebaseFirestore.getInstance()
    private val docRef = db.collection("pantries").document("0XYZS3PgeIW9Cw6hAvgx")

    private val _text = MutableLiveData<String>().apply {
        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                value = document.get("item").toString()
            } else {
                Log.d(TAG, "No such document")
            }
        }
    }
    val text: LiveData<String> = _text

}


/*
* val docRef = db.collection("pantries").document("0XYZS3PgeIW9Cw6hAvgx")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
*
*
*
*
*
* */