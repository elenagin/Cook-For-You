package com.example.cookforyou.ui.pantry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookforyou.R
import kotlinx.android.synthetic.main.pantry_card.view.*


/**
 * author: Elena Ginebra Z.
 * date: 10 Nov 2020
 * description: PantryAdapter has holder for PantryFragment, adapts database info for recyclerview
 */
class PantryAdapter(var pantryList: List<PantryItem>) :
    RecyclerView.Adapter<PantryAdapter.PantryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PantryHolder(layoutInflater.inflate(R.layout.pantry_card, parent, false))
    }

    override fun onBindViewHolder(holder: PantryHolder, position: Int) {
        holder.render(pantryList[position])
    }

    override fun getItemCount(): Int = pantryList.size

    /**
     * author: Elena Ginebra Z.
     * date: 10 Nov 2020
     * description: PantryHolder information holder for PantryAdapter
     */
    class PantryHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun render(pantryList: PantryItem) {
            itemView.label_name.text = pantryList.item
            itemView.label_amount.text = pantryList.amount.toString()
            itemView.label_unit.text = pantryList.unit
        }
    }
}