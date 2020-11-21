package com.example.cookforyou.ui.pantry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import com.google.firebase.firestore.DocumentSnapshot

class PantryAdapter(private val pantryItem: MutableMap<String, Any>) :
    RecyclerView.Adapter<PantryAdapter.PantryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PantryHolder(layoutInflater.inflate(R.layout.pantry_card, parent, false))
    }

    override fun onBindViewHolder(holder: PantryHolder, position: Int) {
        //holder.render(pantryItem[position] as PantryItem)
    }

    override fun getItemCount(): Int = pantryItem.size

    class PantryHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(pantryItem: PantryItem) {

        }
    }
}