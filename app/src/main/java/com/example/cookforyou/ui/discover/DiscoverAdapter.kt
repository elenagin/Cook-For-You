package com.example.cookforyou.ui.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.discover_grid_layout.view.*


/**
 * author: Elena Ginebra Z.
 * date: 01 Dec 2020
 * description: DiscoverAdapter has holder for DiscoverFragment, adapts database info for recyclerview
 */
class DiscoverAdapter(var recipesList: List<RecipeItem>) :
    RecyclerView.Adapter<DiscoverAdapter.DiscoverHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DiscoverHolder(layoutInflater.inflate(R.layout.discover_grid_layout, parent, false))
    }

    override fun onBindViewHolder(holder: DiscoverHolder, position: Int) {
        holder.render(recipesList[position])
    }

    override fun getItemCount(): Int = recipesList.size

    /**
     * author: Elena Ginebra Z.
     * date: 01 Dec 2020
     * description: Discover information holder for DiscoverAdapter
     * */
    class DiscoverHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(recipesList: RecipeItem) {
            itemView.gridImages.text = recipesList.name
            itemView.setOnClickListener {
                itemView.findNavController().navigate(R.id.recipeFragment)
            }
        }
    }
}