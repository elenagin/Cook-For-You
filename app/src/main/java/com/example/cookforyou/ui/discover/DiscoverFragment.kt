package com.example.cookforyou.ui.discover


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import com.google.android.gms.tasks.Continuation
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.discover_card.view.*


private const val TAG = "DiscoverFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverFragment fragment for DiscoverItem, loads database data
 */
class DiscoverFragment : Fragment() {
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
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
        //card = inflater.inflate(R.layout.discover_card, container, false)
        //val imageButton = card.findViewById(R.id.discoverImage)
        //val title = card.findViewById(R.id.discoverName)


        loadData()

        rvFirestoreList = root.findViewById(R.id.rvDiscoverImages) as RecyclerView
        rvFirestoreList.layoutManager = GridLayoutManager(context, 2)
        rvFirestoreList.adapter = adapter

        /*imageView.setOnClickListener{
            val bundle = bundleOf("name" to title)
            findNavController().navigate(R.id.recipeFragment, bundle)
        }*/

        //Log.d(TAG, (recipesList1 union recipesList2 union recipesList3).toString())
        //var recipesList = recipesList1 union recipesList2 union recipesList3
        //adapter.updateDataSet(recipesList.toList().toMutableList())
        return root
    }

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun loadData() {
        firebaseRepo.getIngredientOneRecipes().addOnCompleteListener { r1 ->
            if (r1.isSuccessful) {
                recipesList1 = r1.result!!.toObjects(DiscoverItem::class.java)
                firebaseRepo.getIngredientTwoRecipes().addOnCompleteListener { r2 ->
                    if (r2.isSuccessful) {
                        recipesList2 = r2.result!!.toObjects(DiscoverItem::class.java)
                        firebaseRepo.getIngredientThreeRecipes().addOnCompleteListener { r3 ->
                            if (r3.isSuccessful) {
                                recipesList3 = r3.result!!.toObjects(DiscoverItem::class.java)
                                recipesList =
                                    (recipesList1 union recipesList2 union recipesList3).toList()
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
    }

}
