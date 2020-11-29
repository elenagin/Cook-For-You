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

private const val TAG = "PantryFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: PantryFragment fragment for PantryItem, loads database data
 */
class PantryFragment : Fragment() {
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var pantryList: List<PantryItem> = ArrayList()
    private var adapter: PantryAdapter = PantryAdapter(pantryList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)

        loadData()

        rvFirestoreList = root.findViewById(R.id.rvPantryList) as RecyclerView
        rvFirestoreList.layoutManager = LinearLayoutManager(context)
        rvFirestoreList.adapter = adapter

        return root
    }


    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun loadData() {
        firebaseRepo.getPantryItem().addOnCompleteListener {
            if (it.isSuccessful) {
                pantryList = it.result!!.toObjects(PantryItem::class.java)
                adapter.pantryList = pantryList
                adapter.notifyDataSetChanged()
            } else {
                Log.d(TAG, "Error")
            }
        }
    }
}
