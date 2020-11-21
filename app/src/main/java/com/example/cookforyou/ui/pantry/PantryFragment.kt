package com.example.cookforyou.ui.pantry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import com.example.cookforyou.ui.discover.DiscoverViewModel
import com.example.cookforyou.ui.settings.SettingsViewModel
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "PantryFragment"

class PantryFragment : Fragment() {
    private lateinit var rvPantryList: RecyclerView
    private lateinit var pantryViewModel: PantryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pantryViewModel =
            ViewModelProviders.of(this).get(PantryViewModel::class.java)

        // Sets main views
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)
        rvPantryList = root.findViewById(R.id.rvPantryList) as RecyclerView
        val textView: TextView = root.findViewById(R.id.addItemButtonLabel)
        rvPantryList.layoutManager = LinearLayoutManager(context)

        //Sets text values
        pantryViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}


/*
*
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
* */