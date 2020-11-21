package com.example.cookforyou.ui.pantry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "PantryFragment"

class PantryFragment : Fragment() {
    private lateinit var rvPantryList: RecyclerView
    var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)
        rvPantryList = root.findViewById(R.id.rvPantryList) as RecyclerView
        rvPantryList.layoutManager = LinearLayoutManager(context)
        val docRef = db.collection("pantries").document("0XYZS3PgeIW9Cw6hAvgx")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    val adapter = document.data?.let { PantryAdapter(it) }
                    rvPantryList.adapter = adapter
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
        return root
    }
}