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
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "PantryFragment"

class PantryFragment : Fragment() {
    private val pantryList = listOf(
        PantryItem("Apples", 5, "unit(s)"),
        PantryItem("Salt", 2, "Tablespoons"),
        PantryItem("Cinnamon", 1, "Bottle"),
    )

    //private lateinit var pantryViewModel: PantryViewModel
    private lateinit var rvPantryList: RecyclerView
    var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //pantryViewModel =
        //ViewModelProviders.of(this).get(PantryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)
        rvPantryList = root.findViewById(R.id.rvPantryList) as RecyclerView
        rvPantryList.layoutManager = LinearLayoutManager(context)
        val adapter = PantryAdapter(pantryList)
        rvPantryList.adapter = adapter
        Log.w(TAG, "hmmm")
        val docRef = db.collection("pantries").document("0XYZS3PgeIW9Cw6hAvgx")
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

        return root
    }
}