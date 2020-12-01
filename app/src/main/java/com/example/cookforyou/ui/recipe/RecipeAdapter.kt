package com.example.cookforyou.ui.recipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import com.example.cookforyou.ui.myRecipes.MyRecipesItem
import kotlinx.android.synthetic.main.pantry_card.view.*
import kotlinx.android.synthetic.main.recipe_layout.view.*


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: RecipesAdapter has holder for RecipesFragment, adapts database info for recyclerview
 */
class RecipeAdapter(var recipesList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipesHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return RecipesHolder(layoutInflater.inflate(R.layout.recipe_layout, parent, false))
        }

        override fun onBindViewHolder(holder: RecipesHolder, position: Int) {
            holder.render(recipesList[position])
        }

        override fun getItemCount(): Int = recipesList.size

        /**
         * author: Elena Ginebra Z.
         * date: 10 Nov 2020
         * description: RecipesHolder information holder for RecipesAdapter
         * */
        class RecipesHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun render(recipesList: Recipe) {
                itemView.label_recipe_name.text = recipesList.name
                itemView.label_amount_ingredient1.text = recipesList.ingredient1
                itemView.label_amount_ingredient2.text = recipesList.ingredient2
                itemView.label_amount_ingredient3.text = recipesList.ingredient3
            }
        }


}