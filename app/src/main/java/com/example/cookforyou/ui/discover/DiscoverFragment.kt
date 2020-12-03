package com.example.cookforyou.ui.discover


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R


private const val TAG = "DiscoverFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverFragment fragment for DiscoverItem, loads database data
 */
class DiscoverFragment : Fragment() {
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var tempArray: MutableList<PantryItem> = ArrayList()
    private var recipesList: MutableList<DiscoverItem> = ArrayList()
    private var recipesList1: MutableList<DiscoverItem> = ArrayList()
    private var recipesList2: MutableList<DiscoverItem> = ArrayList()
    private var recipesList3: MutableList<DiscoverItem> = ArrayList()
    private var adapter: DiscoverAdapter = DiscoverAdapter(recipesList)
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_discover, container, false)

        loadData()

        rvFirestoreList = root.findViewById(R.id.rvDiscoverImages) as RecyclerView
        rvFirestoreList.layoutManager = GridLayoutManager(context, 2)
        rvFirestoreList.adapter = adapter

        return root
    }

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun loadData() {
        firebaseRepo.getPantryItems().addOnCompleteListener { r0 ->
            if (r0.isSuccessful) {
                tempArray = r0.result!!.toObjects(PantryItem::class.java)

                val newList = tempArray.map { it.item }
                Log.d(TAG, newList.toString())
                firebaseRepo.getIngredientOneRecipes(newList).addOnCompleteListener { r1 ->
                    if (r1.isSuccessful) {
                        recipesList1 = r1.result!!.toObjects(DiscoverItem::class.java)
                        firebaseRepo.getIngredientTwoRecipes(newList)
                            .addOnCompleteListener { r2 ->
                                if (r2.isSuccessful) {
                                    recipesList2 = r2.result!!.toObjects(DiscoverItem::class.java)
                                    //Log.d("22222", recipesList1.toString())
                                    firebaseRepo.getIngredientThreeRecipes(newList)
                                        .addOnCompleteListener { r3 ->
                                            if (r3.isSuccessful) {
                                                recipesList3 =
                                                    r3.result!!.toObjects(DiscoverItem::class.java)
                                                recipesList =
                                                    (recipesList1 intersect recipesList2 intersect recipesList3).toList()
                                                        .toMutableList()
                                                adapter.updateDataSet(recipesList)
                                            } else {
                                                Log.d(TAG, "Error")
                                            }
                                        }
                                } else {
                                    Log.d(TAG, "Error")
                                }
                            }
                    } else {
                        Log.d(TAG, "Error")
                    }
                }
            } else {
                Log.d(TAG, "Error")
            }
        }


    }

}
