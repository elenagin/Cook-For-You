package com.example.cookforyou.ui.pantry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import java.util.ArrayList

class PantryAdapter(private val pantryItem: ArrayList<PantryItem>) :
    RecyclerView.Adapter<PantryAdapter.PantryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PantryHolder(layoutInflater.inflate(R.layout.pantry_card, parent, false))
    }

    override fun onBindViewHolder(holder: PantryHolder, position: Int) {
        holder.render(pantryItem[position])
    }

    override fun getItemCount(): Int = pantryItem.size

    class PantryHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(pantryItem: PantryItem) {

        }
    }
}