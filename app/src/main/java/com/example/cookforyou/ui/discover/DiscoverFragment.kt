package com.example.cookforyou.ui.discover

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import com.example.cookforyou.ui.myRecipes.FirebaseRepo


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: DiscoverFragment fragment from Navigation bar works as a search recipes module
 */
class DiscoverFragment : Fragment() {
    private lateinit var rvImages: RecyclerView
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var recipesList: List<RecipeItem> = ArrayList()
    private var adapter: DiscoverAdapter = DiscoverAdapter(recipesList)
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_discover, container, false)

        loadData()
        rvImages = root.findViewById(R.id.rvImages) as RecyclerView
        rvImages.layoutManager = GridLayoutManager(
            context,
            2
        )
        adapter = DiscoverAdapter(recipesList)
        rvImages.adapter = adapter

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
                recipesList = it.result!!.toObjects(RecipeItem::class.java)
                Log.d("PantryFragment", recipesList.toString())
                adapter.recipesList = recipesList
            } else {
                Log.d(TAG, "Error")
            }
        }
    }
}
