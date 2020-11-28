package com.example.cookforyou.ui.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.pantry_card.view.*

class MyRecipesAdapter(var recipesList: List<MyRecipesItem>) :
    RecyclerView.Adapter<MyRecipesAdapter.MyRecipesHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecipesHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return MyRecipesHolder(layoutInflater.inflate(R.layout.recipes_card, parent, false))
        }

        override fun onBindViewHolder(holder: MyRecipesHolder, position: Int) {
            holder.render(recipesList[position])
        }

        override fun getItemCount(): Int = recipesList.size


        class MyRecipesHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun render(recipesList: MyRecipesItem) {
                itemView.label_name.text = recipesList.name
            }
        }
}