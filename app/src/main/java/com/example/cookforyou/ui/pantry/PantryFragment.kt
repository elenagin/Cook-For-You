package com.example.cookforyou.ui.pantry

import android.app.AlertDialog
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

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
/*

    /**
     * Receives all touch & gesture actions from user and responds.
     */
    private fun configuraItemTouchHelper() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT
        ) {

            /**
             * When users rearranges (moves), will override onMove and rearrange items from
             * view as well as notify the view model.
             */
            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val sourcePosition = viewHolder.adapterPosition
                val targetPosition = target.adapterPosition
                Collections.swap(tablaCosasViewModel.inventario, sourcePosition, targetPosition)
                adapter?.notifyItemMoved(sourcePosition, targetPosition)
                return true
            }

            /**
             * When users swipes, will override onSwiped and remove item from view as well as
             * update the view model.
             */
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.LEFT) {
                    val dialogBuilder = AlertDialog.Builder(context)
                    dialogBuilder.setMessage("Are you sure you want to delete this Thingy?")
                        .setCancelable(false)
                        .setPositiveButton(
                            "Proceed"
                        ) { dialog, _ ->
                            dialog.run {
                                tablaCosasViewModel.remove(viewHolder.adapterPosition)
                                cosaRecyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                                Log.d(TAG, "Deleted")
                            }
                        }
                        .setNegativeButton(
                            "Cancel"
                        ) { dialog, _ ->
                            dialog.run {
                                cosaRecyclerView.adapter?.notifyItemChanged(viewHolder.adapterPosition)
                                Log.d(TAG, "Cancelled")
                            }
                        }

                    val alert = dialogBuilder.create()
                    alert.setTitle("Delete Thingy?")
                    alert.show()
                }
            }
        }

        /**
         * Detected gesture acts on Recycler View
         */
        val gestureDetector = ItemTouchHelper(itemTouchCallback)
        gestureDetector.attachToRecyclerView(cosaRecyclerView)
    }*/
}
