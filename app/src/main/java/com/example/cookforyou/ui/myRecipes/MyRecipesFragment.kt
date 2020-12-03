package com.example.cookforyou.ui.myRecipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R

private const val TAG = "RecipesFragment"


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: MyRecipesFragment fragment for MyRecipesItem, loads database data
 */
class MyRecipesFragment : Fragment() {
    private lateinit var rvFirestoreList: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var recipesList: List<MyRecipesItem> = ArrayList()
    private var adapter: MyRecipesAdapter = MyRecipesAdapter(recipesList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.list_of_recipes_recycler_view, container, false)

        loadData()
        rvFirestoreList = root.findViewById(R.id.list_of_recipes_rv) as RecyclerView
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
        firebaseRepo.getRecipe().addOnCompleteListener {
            if (it.isSuccessful) {
                recipesList = it.result!!.toObjects(MyRecipesItem::class.java)
                Log.d("PantryFragment", recipesList.toString())
                adapter.recipesList = recipesList
                adapter.notifyDataSetChanged()
            } else {
                Log.d(TAG, "Error")
            }
        }
    }
}
