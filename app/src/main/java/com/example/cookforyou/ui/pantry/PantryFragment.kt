package com.example.cookforyou.ui.pantry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R

class PantryFragment : Fragment() {
    val pantryList = listOf(
        PantryItem ("Apples", 5, "unit(s)"),
        PantryItem ("Salt", 2, "Tablespoons"),
        PantryItem ("Cinnamon", 1, "Bottle"),
    )

    private lateinit var pantryViewModel: PantryViewModel
    private lateinit var rvPantryList: RecyclerView
    private var adapter: PantryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        pantryViewModel =
            ViewModelProviders.of(this).get(PantryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pantry, container, false)
        rvPantryList = root.findViewById(R.id.rvPantryList) as RecyclerView
        rvPantryList.layoutManager = LinearLayoutManager(context)
        val adapter = PantryAdapter(pantryList)
        rvPantryList.adapter = adapter

        return root
    }
}