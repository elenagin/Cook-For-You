package com.example.cookforyou.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cookforyou.R


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: HomeFragment is the Home fragment, connected to Home View Graph,
 * sets button listeners for Home view
*/
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        root = inflater.inflate(R.layout.fragment_home, container, false)
        val favButton = root.findViewById<Button>(R.id.favouritesB)
        val breakfastButton = root.findViewById<Button>(R.id.breakfastB)
        val lunchButton = root.findViewById<Button>(R.id.lunchB)
        val dinnerButton = root.findViewById<Button>(R.id.dinnerB)
        val randomButton = root.findViewById<Button>(R.id.randomB)

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
            navigateToRecipesFragment()
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
}