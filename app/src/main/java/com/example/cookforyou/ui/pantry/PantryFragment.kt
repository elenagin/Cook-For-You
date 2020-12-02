package com.example.cookforyou.ui.pantry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
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
    private var pantryList: MutableList<PantryItem> = mutableListOf()
    private lateinit var addButton: ImageButton
    private lateinit var addButtonCardView: CardView
    private var adapter: PantryAdapter = PantryAdapter(pantryList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)
        addButton = root.findViewById(R.id.addItemButton)
        addButtonCardView = root.findViewById(R.id.cardAddItemPantry)
        addButton.setOnClickListener {
            findNavController().navigate(R.id.addPantryItemFragment)
        }

        addButtonCardView.setOnClickListener{
            findNavController().navigate(R.id.addPantryItemFragment)
        }
        loadData()

        rvFirestoreList = root.findViewById(R.id.rvPantryList) as RecyclerView
        rvFirestoreList.layoutManager = LinearLayoutManager(context)
        rvFirestoreList.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
        itemTouchHelper.attachToRecyclerView(rvFirestoreList)

        return root
    }


    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun loadData() {
        firebaseRepo.getPantryItems().addOnCompleteListener {
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
