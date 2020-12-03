package com.example.cookforyou.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cookforyou.R
import com.example.cookforyou.ui.discover.DiscoverItem
import com.example.cookforyou.ui.recipe.Recipe


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: HomeFragment is the Home fragment, connected to Home View Graph,
 * sets button listeners for Home view
 */
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root: View
    private var name: String = ""
    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var recipe: MutableList<RecipeItem> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        root = inflater.inflate(R.layout.fragment_home, container, false)
        val favButton = root.findViewById<Button>(R.id.favouritesButton)
        val breakfastButton = root.findViewById<Button>(R.id.breakfastB)
        val lunchButton = root.findViewById<Button>(R.id.lunchB)
        val dinnerButton = root.findViewById<Button>(R.id.dinnerB)
        val randomButton = root.findViewById<Button>(R.id.randomRecipeButton)

        favButton.setOnClickListener {
            navigateToRecipesFragment()
        }

        breakfastButton.setOnClickListener {
            navigateToRecipesFragment()
        }

        lunchButton.setOnClickListener {
            navigateToRecipesFragment()
        }

        dinnerButton.setOnClickListener {
            navigateToRecipesFragment()
        }

        randomButton.setOnClickListener {
            val randomNumber = arrayOf(0, 1, 3, 4, 5, 6, 7)
            getRandomName(randomNumber.random())
            Log.d("Random", recipe.size.toString())
        }

        return root
    }

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: called by buttons to navigate to different to MyRecipesFragment
     */
    private fun navigateToRecipesFragment() {
        root.findNavController().navigate(R.id.myRecipesFragment)
    }


    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: load Data from FirebaseRepo
     */
    private fun getRandomName(rand: Int) {
        firebaseRepo.getRandomRecipeName(rand).addOnCompleteListener {
            if (it.isSuccessful) {
                recipe = it.result!!.toObjects(RecipeItem::class.java)
                name = recipe.find { it.id == rand }?.name.toString()
                val bundle = bundleOf("name" to name)
                findNavController().navigate(R.id.recipeFragment, bundle)
            } else {
                Log.d("TAG", "Error")
            }
        }
    }
}