package com.example.cookforyou.ui.pantry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R

private const val TAG = "PantryFragment"

class PantryFragment : Fragment() {
    private lateinit var pantryViewModel: PantryViewModel
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var pantryList: List<PantryItem> = ArrayList()
    private var adapter: PantryAdapter = PantryAdapter(pantryList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Sets main views
        //pantryViewModel = ViewModelProvider(this).get(PantryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)

        loadData()

        rvFirestoreList = root.findViewById(R.id.rvPantryList) as RecyclerView
        rvFirestoreList.layoutManager = LinearLayoutManager(context)
        rvFirestoreList.adapter = adapter

        return root
    }


    private fun loadData() {
        firebaseRepo.getPantryItem().addOnCompleteListener {
            if (it.isSuccessful) {
                pantryList = it.result!!.toObjects(PantryItem::class.java)
                Log.d("ErrorPantryFragment", pantryList.toString())
                adapter.pantryList = pantryList
                adapter.notifyDataSetChanged()
            } else {
                Log.d("ErrorPantryFragment", "Bloody Error")
            }
        }
    }

}

//val textView: TextView = root.findViewById(R.id.addItemButtonLabel)
//val textViewRV: TextView = root.findViewById(R.id.label_name)
/*adapter = PantryAdapter(pantryViewModel.text.observe(viewLifecycleOwner, {
    textViewRV.text = it
}))

//Sets text values
pantryViewModel.text.observe(viewLifecycleOwner, {
    textView.text = it
})*/


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